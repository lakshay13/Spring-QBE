# Spring QBE

The Spring Query By Example Project implements the QBE feature

## Query by Example (QBE) is a user-friendly querying technique with a simple interface. It allows dynamic query creation
and does not require to write queries containing field names. In fact, Query by Example does not require to write
queries using store-specific query languages at all.

###The Query by Example API consists of three parts:

a) Probe: That is the actual example of a domain object with populated fields.

b) ExampleMatcher: The ExampleMatcher carries details on how to match particular fields. It can be reused across multiple
 Examples.

c) Example: An Example consists of the probe and the ExampleMatcher. It is used to create the query.

