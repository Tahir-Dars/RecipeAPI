# Recipe API

A Spring Boot REST API application for managing and retrieving recipes with filtering capabilities.

## Project Overview

**Recipe API** is a backend service built with Spring Boot that provides REST endpoints to manage recipes. The API allows users to create recipes, retrieve recipes by various criteria such as category and rating, and supports complex filtering by combining multiple parameters.

This project demonstrates modern Java Spring Boot development practices including REST API design, data persistence, DTOs, and service-oriented architecture.

## Features

- **Create Recipes** - Add new recipes to the system
- **Retrieve All Recipes** - Get a list of all available recipes
- **Filter by Category** - Retrieve recipes filtered by category
- **Filter by Rating** - Retrieve recipes filtered by rating (numeric)
- **Retrieve by ID** - Get a specific recipe by its unique identifier
- **Combined Filtering** - Retrieve recipes filtered by both rating and category simultaneously
- **Error Handling** - Comprehensive exception handling with custom error responses

## Technology Stack

- **Framework**: Spring Boot 4.1.0
- **Language**: Java 25
- **Data Persistence**: Spring Data JPA
- **Database**: H2 (in-memory)
- **Build Tool**: Maven
- **Additional Libraries**: 
  - Lombok (for reducing boilerplate code)
  - ModelMapper (for DTO mapping)
  - Spring Validation

## API Endpoints

### Create a Recipe
```
POST /api/v1/newrecipe
```

### Get All Recipes
```
GET /api/v1/recipes
```

### Get Recipes by Category
```
GET /api/v1/recipesaccordintocategory?category=<CATEGORY>
```

### Get Recipe by ID
```
GET /api/v1/recipe/{recipeId}
```

### Get Recipes by Rating
```
GET /api/v1/recipesaccordintorating?rating=<RATING>
```

### Get Recipes by Rating and Category (Combined)
```
GET /api/v1/getRating&CategorySpecificRecipes?rating=<RATING>&category=<CATEGORY>
```

## Project Structure

```
RecipeAPI/
├── src/main/java/com/letsreadhere/recipeapi/
│   ├── RecipeApiApplication.java          # Spring Boot entry point
│   ├── controller/
│   │   └── RecipeController.java           # REST API endpoints
│   ├── service/
│   │   ├── RecipeService.java              # Service interface
│   │   └── RecipeServiceMgr.java           # Service implementation
│   ├── repository/
│   │   └── RecipeRepository.java           # Data access layer
│   ├── model/
│   │   ├── Recipe.java                     # Entity model
│   │   └── DTOs/
│   │       ├── RecipeDTO.java              # Recipe data transfer object
│   │       └── API_ResponseDTO.java        # API response wrapper
│   ├── configs/
│   │   └── ApplicationConfigs.java         # Application configuration
│   ├── exceptions/
│   │   ├── APIException.java               # Custom API exception
│   │   ├── ResourceNotFoundException.java   # Resource not found exception
│   │   └── ExceptionControllerGlobally.java # Global exception handler
│   └── helper/
│       └── DataLoader.java                 # Initial data setup
└── pom.xml                                  # Maven configuration
```

## Getting Started

### Prerequisites
- Java 25
- Maven 3.6+

### Installation

1. Clone the repository:
```bash
git clone <repository-url>
```

2. Navigate to the project directory:
```bash
cd RecipeAPI
```

3. Build the project:
```bash
mvn clean install
```

4. Run the application:
```bash
mvn spring-boot:run
```

The API will be available at `http://localhost:8080`

## Configuration

Application configuration can be modified in `src/main/resources/application.properties`

## Full Documentation

For comprehensive documentation including detailed requirements, specifications, and additional information about this project, please refer to the included **requirements-document.pdf** file in the root directory.

## License

This project is licensed under the **MIT License** - you are free to use, clone, modify, and distribute this project for personal or commercial purposes. Feel free to adapt it to your needs and add your own enhancements.

See the LICENSE file for more details, or simply:
- **Clone** this repository
- **Modify** it according to your project requirements
- **Use** it freely in your own projects
- **Share** it with others

No restrictions - use it however you need! 🚀

