# Customer Reviews API 
Supports operations for writing reviews and listing reviews for a product but with no sorting or filtering.

### Prerequisites
MySQL needs to be installed and configured.
On a Mac, use 
```bash
brew install mysql
brew service start mysql

## Now set up mysql
```

### About
1. There are 3 entities, Product, Review and Comment
1. There are 3 controllers, one for each entity
3. Controller Documentation is powered by Swagger 2 available on `/swagger-ui.html`
4. Tests are created for each of the Entity's Repository, which run by simple command, 
```bash
mvn clean test
```
