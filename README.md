# unit-testing-best-practices

Tests are just as important as production code, but they are different. Through trial and error we have learnt &
continue to learn better testing practices but much of that knowledge is not yet widespread. Through the code here which
can be understood in tandem with our sessions, we try to make an effort to spread this knowledge.

## Session-1: Basic Idea about how to do TDD in right way and why it is important

ISBN controller just calls ISBN service to validate if given ISBN is valid or not.  
ISBN service has the business logic of validation.
In comments steps are given which are to be followed while doing actual TDD.

## Session-2: Tiny universe principle. State verification over Behaviour verification

Customer controller comes with an API that saves customers by validating them CustomerControllerTestV1 and
CustomerControllerTestV2 show how tests can improve progressively, when they run independently. Doing State verification
over behaviour verification is better since Behaviour of code(Structure of the code) is bound to change or refactor
whereas state will remain as long as the business requirements stay the same.

## Session-3:

## Session-4:

## Session-5:

## Session-6: Relating ROI with Unit Testing Best Practices

Furniture Rental is a startup that wants to let its customers rent furniture items of various types (regular, luxury,
children). The rent charges and loyalty points are dependent on the number of days for which the item is rented.

FurnitureTestV1, FurnitureTestV2 & FurnitureTestV3 show progressively improving tests (V1 being negative ROI and V2 & V3
increasingly positive ROI) by applying the testing best practices.

#### Unit Testing Best Practices reviewed:

- Tiny Universe
- Inline Setup
- Replace loop with individual tests
- Expect Literal
- DAMP not DRY
- Avoid Implementation Overspecification
- One Assert Per Test
- Arrange-Act-Assert
- Naming Convention

## Session-7:

## Session-8:

## Session-9: Creating Simplified assertions and handling time interactions in tests
### Simplified assertions
- Create custom assertions if there were several assertions that focused on the same type of assertions or have similar patterns or duplication that’s beginning to appear pointing towards a custom assertion.
- If you find yourself repeating any idea in multiple test cases, (then and only then) look for a higher level concept that can be extracted and reused.
- Such custom assertions should be created on a global level instead of per test class level, hence solving problems globally .
- Assert Last: Write single line assertion as the last line of the test

We cover two scenarios for Simplified Assertions:
1. Exception Handling
2. Reactive code or equivalent library code with complex assertions

### Time interactions
- Use constructor dependency Injection to inject clocks(or equivalent timeserver) for controllers, services etc.
Tests can then inject clock with fixed time.
- Use parameter injection when injecting a clock is not a feasible solution(eg. domain models). In the production code,
the invoking controller/service which has a clock can inject the date as the method parameter.
The tests for domain model can inject the date object directly.

## Session-10: 90% Solitary and 10% Sociable unit tests

Weather Forecasting App is used to show weather conditions for given location coordinates.

WeatherForecastTestV1, WeatherForecastTestV2 & WeatherForecastTestV3 show different versions of tests as follows:-
1. WeatherForecastTestV1 has unit tests which are Solitary (Mockist Approach)
2. WeatherForecastTestV2 has unit tests which are Sociable (Classist Approach)
3. WeatherForecastTestV3 has unit tests with around 90% Solitary and 10% Sociable

Unit Tests in combination of Solitary & Sociable provide more robustness and reliability.

## Session-11: Test Doubles- Mocks and Stubs

Furniture Rent App is used to rent furniture available in the system. 

It exposes a REST API to rent furniture with following contract:-
POST /furniture/{id}/rent
-> 200 ok - When furniture is available for rent
-> 422 unprocessable entity - When furniture is not available for rent
-> 400 bad request - When id is not valid integer

#### Unit Testing Best Practices reviewed:
- Simplified assertions
- Handling Time Interactions
- Assert Last
- Sensible Defaults in test data setup eg. EPOCH
