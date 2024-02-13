# Description
TravelHelper is a Java Swing-based desktop application designed to provide users with weather information, currency exchange rates, and quick access to Wikipedia articles based on user input. The application utilizes various APIs to fetch weather data, currency exchange rates, and dynamically load Wikipedia articles.

## Project Structure
The project consists of the following components:

- Controller: Handles the application's logic, orchestrating interactions between the service layer and the view.
- Service: Implements the business logic and interacts with external APIs to fetch weather data and currency exchange rates.
- View: Contains the user interface components built using Java Swing, providing a simple browser interface for users to interact with.
## Files
### Controller
- Controller.java: Manages the application's logic, including fetching weather data, currency exchange rates, and loading Wikipedia articles based on user input.
### Service
- APIs
  - ExchangeRateAPI.java: Handles interactions with an external API to fetch currency exchange rates.
  - NbpAPI.java: Interfaces with an external API to retrieve National Bank of Poland (NBP) exchange rates.
  - OpenWeatherAPI.java: Manages interactions with the OpenWeatherMap API to fetch weather data.
- Service.java: Implements the main business logic of the application, coordinating interactions with the external APIs.
### View
- TravelHelper.java: Provides the user interface for the application, allowing users to input a country, city, and currency code. It displays weather information, currency exchange rates, and loads Wikipedia articles based on user input.
### Main
- Main.java: Entry point of the application. Initializes the service layer and the view components and connects them through the controller.
## Features
- Fetches weather data, currency exchange rates, and Wikipedia articles based on user input.
- Provides a user-friendly interface built with Java Swing.
- Utilizes external APIs to retrieve up-to-date weather and financial information.
- Dynamically loads Wikipedia articles for quick reference.

## Getting Started
To run the TravelHelper application, follow these steps:

- Ensure you have Java Development Kit (JDK) installed on your system.
- Clone or download the project repository to your local machine.
- Open the project in your preferred Java development environment (e.g., IntelliJ IDEA, Eclipse).
- Replace "YOUR_API_KEY" in the OpenWeatherAPI and ExchangeRateAPI constructors with your actual API keys obtained from OpenWeatherMap and the currency exchange rate provider.
- Build the project to compile the source code.
- Run the Main.java file to start the application.
- Enter the desired country, city, and currency code in the provided fields.
- Click the "GO" button to fetch weather information, currency exchange rates, and load a Wikipedia article based on your input.

# License
This project is licensed under the MIT License - see the LICENSE file for details.





