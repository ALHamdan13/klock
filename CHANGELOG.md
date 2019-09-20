# Changelog

## [1.7.2](https://github.com/korlibs/klock/compare/1.7.1...1.7.2)

* Support optional format parts [#27](https://github.com/korlibs/klock/issues/27)

## [1.7.1](https://github.com/korlibs/klock/compare/1.7.0...1.7.1)

* Supports TimeZone parsing. Fixes [#14](https://github.com/korlibs/klock/pull/14)
* Added SerializableDateTime wrapping a DateTime to allow serialization along DateTimeTz. Fixes [#17](https://github.com/korlibs/klock/pull/17)
* New PatternDateFormat parsing system. Fixes [#33](https://github.com/korlibs/klock/pull/33)
* Fixes a NumberFormatException. Fixes [#37](https://github.com/korlibs/klock/pull/37)
* Verifies that #38 is fixed. Fixes [#38](https://github.com/korlibs/klock/pull/38)
* klock-locale now includes ExtendedTimezoneNames with TimeZone names for parsing. Fixes [#41](https://github.com/korlibs/klock/pull/41)
* Now publishing to NPM: <https://www.npmjs.com/package/@korlibs/klock> Fixes [#54](https://github.com/korlibs/klock/pull/54)
* Fixes a bug when generating a span from a DateTimeRange. Fixes [#63](https://github.com/korlibs/klock/pull/63)

## [1.7.0](https://github.com/korlibs/klock/compare/1.5.0...1.7.0)

* Kotlin 1.3.50
* Added Date and Time classes
* Revamped DateTimeRange
* Added DateTimeRangeSet
* Some fixes to ISO8601
* Fixed: [#61](https://github.com/korlibs/klock/pull/61) thanks to AndreasMattsson 

## 1.4.0

* Kotlin 1.3.30
* Add support for ISO-8601 parsing and formatting

## 1.3.1

* Add locale support

## 1.2.2

* `DateTime`, `min`, `max`, `clamp`

## 1.2.0

* Gradle 5.2 and Kotlin 1.3.21 without metadata publishing

