# Url to connect to graphQL

http://localhost:9091/graphiql?path=/graphql

# Connection to h2 console

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


