# unit-testing-best-practices

Tests are just as important as production code, but they are different. Through trial and error we have learnt & 
continue to learn better testing practices but much of that knowledge is not yet widespread. Through the code here which
can be understood in tandem with our sessions, we try to make an effort to spread this knowledge.

## Session-1:
## Session-2:
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

## Session-9: Creating Simplified assertions for problems faced globally

Money Converter is an app that helps get the USD value from your INR. Money has 2 attributes- amount, currency

MoneyTestV1, MoneyTestV2 & MoneyTestV3 show progressively improving tests.
1. V1 being complicated assertion where you have to repeat the same lines of code multiple times.
2. V2 is slightly better since the assertions are inline, it comes with problem of multiple tests creation for amount, even though amount and currency are always co-existent.
3. V3 is the simplified way of testing Money. The assertion in testUtils.kt is a global level method and now can be used by any test across the project which increases readability, ease of use and has usage similar to standard library

#### Unit Testing Best Practices reviewed:
- Inline setup
- Simplified assertions
