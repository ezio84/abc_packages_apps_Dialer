/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */

package com.android.dialer.phonelookup;

import com.android.dialer.phonelookup.blockednumber.DialerBlockedNumberPhoneLookup;
import com.android.dialer.phonelookup.composite.CompositePhoneLookup;
import com.android.dialer.phonelookup.cp2.Cp2PhoneLookup;
import com.google.common.collect.ImmutableList;
import dagger.Module;
import dagger.Provides;

/** Dagger module which binds the PhoneLookup implementation. */
@Module
public abstract class PhoneLookupModule {

  @Provides
  @SuppressWarnings({"unchecked", "rawtype"})
  static ImmutableList<PhoneLookup> providePhoneLookupList(
      Cp2PhoneLookup cp2PhoneLookup,
      DialerBlockedNumberPhoneLookup dialerBlockedNumberPhoneLookup) {
    return ImmutableList.of(cp2PhoneLookup, dialerBlockedNumberPhoneLookup);
  }

  @Provides
  static PhoneLookup<PhoneLookupInfo> providePhoneLookup(
      CompositePhoneLookup compositePhoneLookup) {
    return compositePhoneLookup;
  }
}