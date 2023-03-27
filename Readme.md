# Url to connect to graphQL

http://localhost:9091/graphiql?path=/graphql

# Connection to h2 console

jdbc:h2:mem:books

# Query for pogination

`
{
allBooksPaged(page: 2, size: 1) {
id
name
author {
name
}
rating
}
}
`


