# Url to connect to graphQL

http://localhost:9091/graphiql?path=/graphql

# Connection to h2 console

http://localhost:9091/h2-console

# JDBC connection string

jdbc:h2:mem:books

# Query for pogination

`
query {
allBooksPaged(page :0 , size : 2){
books{
name
}
totalPages
totalElements
}
}
`

# Mutation Example

`
mutation {
createAuthor(name: "Author0004", surname: "Author0004 surname", age: "age 124") {
id
}
}
`


