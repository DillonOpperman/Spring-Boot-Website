<<<<<<< HEAD
# Pigraid - Spring Boot Web Application

A Spring Boot web application featuring a modern website with voting functionality, contact forms, and staff application system.

##  Features

- **Modern Web Interface**: Responsive design with Materialize CSS framework
- **Voting System**: Interactive voting functionality
- **Contact Forms**: Email integration for contact and subscription forms
- **Staff Application System**: Application form processing
- **History Gallery**: Image gallery showcasing project history
- **Shop Interface**: E-commerce ready shop page
- **Email Integration**: SMTP email functionality for form submissions

##  Technology Stack

- **Backend**: Java 17, Spring Boot 3.4.4
- **Frontend**: HTML5, CSS3, JavaScript, Materialize CSS
- **Database**: MySQL 8.0
- **Build Tool**: Maven
- **Template Engine**: Thymeleaf
- **Email**: Spring Boot Mail with Gmail SMTP

##  Prerequisites

Before running this application, make sure you have:

- **Java 17** or higher
- **Maven 3.6+**
- **MySQL 8.0** database
- **Git** (for version control)

##  Getting Started

### 1. Clone the Repository
```bash
git clone <your-repository-url>
cd Website
```

### 2. Environment Setup
1. Copy the environment template:
   ```bash
   cp env.example .env
   ```

2. Edit `.env` file with your actual credentials:
   ```bash
   # Database Configuration
   DATABASE_URL=jdbc:mysql://localhost:3306/pigraid_db
   DATABASE_USERNAME=your_database_username
   DATABASE_PASSWORD=your_database_password
   
   # Mail Configuration
   MAIL_USERNAME=your_email@gmail.com
   MAIL_PASSWORD=your_app_password
   ```

### 3. Database Setup
1. Create a MySQL database named `pigraid_db`
2. The application will use the credentials from your `.env` file

### 4. Email Configuration
The application will use the email settings from your `.env` file

### 5. Build and Run
```bash
# Build the project
mvn clean install

# Run the application
mvn spring-boot:run
```

The application will be available at: `http://localhost:8888`

##  Project Structure

```
Website/
├── src/
│   ├── main/
│   │   ├── java/Website/Website/
│   │   │   └── PigraidApplication.java
│   │   └── resources/
│   │       ├── application.properties
│   │       ├── static/          # Static web assets
│   │       │   ├── css/         # Stylesheets
│   │       │   ├── js/          # JavaScript files
│   │       │   ├── img/         # Images
│   │       │   └── *.html       # HTML pages
│   │       └── templates/       # Thymeleaf templates
│   └── test/                    # Test files
├── pom.xml                      # Maven dependencies
└── README.md
```

##  Configuration

### Database Configuration
The application uses MySQL with the following default settings:
- Host: localhost:3306
- Database: pigraid_db
- Hibernate DDL: update (auto-creates tables)

### Email Configuration
- SMTP Host: smtp.gmail.com
- Port: 587
- Authentication: Required
- TLS: Enabled

### Server Configuration
- Port: 8888
- Context Path: /
- Static Resources: classpath:/static/

##  Pages

- **Home** (`/`) - Landing page with modern design
- **About** (`/about`) - About page with team information
- **Contact** (`/contact`) - Contact form with email integration
- **Vote** (`/vote`) - Voting system interface
- **Shop** (`/shop`) - E-commerce shop page
- **Staff Apply** (`/staff-apply`) - Staff application form
- **History Gallery** (`/HistoryGallery`) - Image gallery

##  Testing

Run the test suite:
```bash
mvn test
```

##  Dependencies

Key dependencies managed by Maven:

- **Spring Boot Starter Web** - Web application framework
- **Spring Boot Starter Thymeleaf** - Template engine
- **Spring Boot Starter Mail** - Email functionality
- **Spring Boot Starter WebFlux** - Reactive web support
- **Spring Boot Starter Test** - Testing framework

##  Deployment

### Local Development
```bash
mvn spring-boot:run
```

### Production Build
```bash
mvn clean package
java -jar target/Website-0.0.1-SNAPSHOT.jar
```

##  Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

##  License

This project is licensed under the MIT License - see the LICENSE file for details.

##  Support

For support, email dopperm2@my.heartland.edu or create an issue in the repository.

##  Security Configuration

### Environment Variables
This project uses environment variables for sensitive configuration:

- **Database credentials** are loaded from environment variables
- **Email credentials** are loaded from environment variables
- **Local development** uses `application-local.properties` (excluded from Git)
- **Production** uses environment variables for security

### Security Best Practices
-  **Sensitive data removed** from version control
-  **Environment variables** used for credentials
-  **Local config** excluded from Git
-  **Production template** provided

### Files to Never Commit:
- `.env` files
- `application-local.properties`
- Any files containing passwords or API keys

---

=======
# Spring-Boot-Website
>>>>>>> 3bc519b9ed7c4b4e491dbd4bfa80a8d3ed2dfb4b
