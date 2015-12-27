# International Phone Input #

## What is it?
**IntlNumberInput** is a custom view for Android that allows the user to enter his phone number in an
elegant and friendly way. It adds a flag dropdown to any input, automatically detects the user's
country, displays a relevant placeholder and auto formats the number as they type.

![IntlPhoneInput](intlphoneinput.png)

![IntlPhoneInput Spinner](intlphoneinput-spinner.png)

## Features
1. Automatically format the number as the user types
2. Automatically set the input placeholder to an example number for the selected country
3. Selecting a country from the dropdown will update the dial code in the input
4. Typing a different dial code will automatically update the displayed flag
5. Easy embedding as a Custom View
6. Listener available to detect validity change
7. Automatically detect phone number when information available

## Download
Download [the latest JAR]() or grab via Maven:
```xml
<dependency>
  <groupId>net.rimoto.intlphoneinput</groupId>
  <artifactId>intlphoneinput</artifactId>
  <version>0.9.0</version>
</dependency>
```
or Gradle:
```groovy
compile 'net.rimoto.intlphoneinput:intlphoneinput:0.9.0'
```

## Usage
It's easy like 1-2-3! 

1. Add the view to your layout XML:
```xml
<net.rimoto.intlphoneinput.IntlPhoneInput
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:id="@+id/my_phone_input" />
```

2. Find it in your java
```java
IntlPhoneInput phoneInputView = (IntlPhoneInput) findById(R.id.my_phone_input);
```

3. Check for validity and get the number!
```java
String myInternationalNumber;
if(phoneInputView.isValid()) {
    myInternationalNumber = phoneInputView.getNumber();
}
```

## Public methods

1. `void setEnabled(boolean enabled)`
2. `void setOnValidityChange(IntlPhoneInputListener listener)`
    ```java
    public interface IntlPhoneInputListener {
            void done(View view, boolean isValid);
        }
    ```
3.


## Attributions

1. Inspired by [intl-tel-input for jQuery](https://github.com/jackocnr/intl-tel-input)
2. Flag images from [region-flags](https://github.com/behdad/region-flags)
3. Original country data from mledoze's [World countries in JSON, CSV and XML](https://github.com/mledoze/countries)
4. Formatting/validation/example number code from [libphonenumber](https://github.com/googlei18n/libphonenumber)

# LICENSE
    Copyright 2015 Rimoto LTD, AlmogBaku
    
    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at
    
      http://www.apache.org/licenses/LICENSE-2.0
    
    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
