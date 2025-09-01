<!-- 

🏥 ICare Medicals is a cutting-edge healthcare application 📱💻 that brings together advanced technologies to ensure comprehensive patient care. 🚑 With separate Android applications for patients and a web app built using Vue.js for administrators, the platform offers a seamless user experience. 😃

👨‍⚕️ Patients can access their personalized Android app, powered by Kotlin, to manage their medical journey with ease. They can schedule appointments, access medical records, receive important updates, and even use the Azure Machine Learning integration for early detection of eye diseases. 👀🔍

👩‍💼 Administrators have the privilege of logging into the web app, where they can efficiently manage and monitor all aspects of the medical system. From overseeing patient appointments to analyzing data from the centralized Spring Boot backend and MySQL database 📊📈, they are equipped with powerful tools to ensure smooth operations.

📶 The integration of SMS gateway ensures seamless communication 💌, keeping patients informed about appointments, test results, and other essential information. This not only improves patient engagement but also contributes to better healthcare outcomes.

ICare Medicals represents a harmonious blend of modern technology and compassionate care, striving to enhance the well-being of patients and streamline medical processes. 💙💻🩺

 -->

# ICare-Medicals

🏥 **ICare Medicals**: A comprehensive healthcare platform featuring Android and web applications, a Vue.js admin dashboard, Spring Boot backend, MySQL database, and Azure Custom Vision for eye disease detection and predictions. Integrated with an SMS gateway for seamless patient communication. 📱💻👩‍💼🌐👁️📊📱💙

![Slide 4_3 - 1](https://github.com/moshdev2213/ICare-Medicals/assets/103739510/ecfba630-151f-49bd-bbce-788a744f50d9)

## Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Architecture](#architecture)
- [Installation and Setup](#installation-and-setup)
  - [Prerequisites](#prerequisites)
  - [Backend Setup](#backend-setup)
  - [Frontend (Web Admin Dashboard) Setup](#frontend-web-admin-dashboard-setup)
  - [Android App Setup](#android-app-setup)
  - [Azure Custom Vision Integration](#azure-custom-vision-integration)
  - [Database Setup](#database-setup)
  - [SMS Gateway Integration](#sms-gateway-integration)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)
- [Contact](#contact)

## Overview

ICare Medicals is a modern healthcare management system designed to enhance patient care through technology. It includes patient-facing Android applications for managing medical journeys, such as scheduling appointments, accessing records, and receiving health updates. Administrators can use a web-based dashboard to oversee operations, analyze data, and manage patient interactions. The system leverages Azure for cloud services and specifically Azure Custom Vision for AI-powered predictions, focusing on early detection of eye diseases via image analysis. An SMS gateway ensures timely notifications to patients, improving engagement and outcomes.

This project aims to bridge the gap between patients and healthcare providers, making medical services more accessible, efficient, and proactive.

## Features

- **Patient Android App**: User-friendly interface for booking appointments, viewing medical history, uploading images for eye disease screening, and receiving SMS notifications.
- **Admin Web Dashboard**: Built with Vue.js for real-time monitoring of appointments, patient data analytics, and system management.
- **AI-Powered Predictions**: Utilizes Azure Custom Vision to analyze eye images and predict potential diseases like glaucoma, cataracts, or diabetic retinopathy.
- **Secure Backend**: Spring Boot API handling data processing, authentication, and integration with Azure services.
- **Database Management**: MySQL for storing patient records, appointment details, and prediction results.
- **SMS Notifications**: Integrated gateway for sending alerts, reminders, and updates to patients' mobile devices.
- **Cloud Usage**:Azure AI features are used for reliable, and seamless AI integration.
- **Data Analytics**: Basic reporting and visualizations for healthcare insights.

## Technologies Used

- **Backend**: Spring Boot (Java)
- **Frontend (Web)**: Vue.js
- **Mobile (Android)**: Kotlin
- **Database**: MySQL
- **Cloud Services**: Azure (including Azure Custom Vision for ML predictions)
- **AI/ML**: Azure Custom Vision for custom image classification models
- **Communication**: SMS & Email Intergrations
- **Other Tools**: Maven/Gradle for builds, Git for version control, Docker for containerization (optional)

## Architecture

![1](https://github.com/moshdev2213/ICare-Medicals/assets/103739510/aa97605f-f91f-430f-9570-d92ab31a1903)

The system follows a microservices-inspired architecture:

1. **Client Layer**: Android app for patients and Vue.js web app for admins.
2. **API Layer**: Spring Boot backend exposing RESTful endpoints.
3. **Data Layer**: MySQL database for persistent storage.
4. **AI Layer**: Azure Custom Vision service for processing uploaded images and generating predictions.
5. **Notification Layer**: SMS gateway for outbound messages.
6. **Cloud Infrastructure**: All components deployable on Azure App Services, Azure SQL Database, and Azure AI services.

Data flow: Patients upload eye images via the app → Backend routes to Azure Custom Vision → Predictions Proccessed → Notifications sent via SMS/Email.

## Installation and Setup

### Prerequisites

- Java JDK 17+ (for backend)
- Node.js 14+ and npm (for Vue.js frontend)
- Android Studio (for mobile app)
- MySQL Server 8+
- Azure Account (with Custom Vision resource provisioned)
- Git
- Optional: Docker for containerized deployment

### Backend Setup

1. Clone the repository:
   ```
   git clone https://github.com/moshdev2213/ICare-Medicals.git
   cd ICare-Medicals/backend
   ```

2. Configure application properties (e.g., `application.properties` or `application.yml`):
   - Set database credentials.
   - Add Azure Custom Vision keys and endpoints.
   - Configure SMS gateway API keys.

3. Build and run:
   ```
   mvn clean install
   mvn spring-boot:run
   ```
   (Assuming Maven is used; adjust for Gradle if applicable.)

### Frontend (Web Admin Dashboard) Setup

1. Navigate to the frontend directory:
   ```
   cd ICare-Medicals/frontend/web
   ```

2. Install dependencies:
   ```
   npm install
   ```

3. Run the development server:
   ```
   npm run dev
   ```

4. Build for production:
   ```
   npm run build
   ```

### Android App Setup

1. Open the Android project in Android Studio:

2. Sync Gradle and build the project.

3. Configure API endpoints and Azure keys in the app's constants or build config.

4. Run on emulator or device.

### Azure Custom Vision Integration

1. Create an Azure Custom Vision project:
   - Go to [customvision.ai](https://www.customvision.ai/).
   - Create a new project for classification (e.g., eye disease types).
   - Upload training images and train the model.
   - Publish the model and note the Prediction URL, Key, and Project ID.

2. In the backend code (e.g., in a service class):
   - Use the Azure Custom Vision SDK or REST API to send images for prediction.

3. Deploy the model and integrate endpoints in the app/backend.

### Database Setup

1. Install MySQL and create a database:
   ```
   CREATE DATABASE icare_medicals;
   ```

2. Run schema scripts (if provided in `/db` directory) or let Spring Boot auto-generate via JPA/Hibernate.

3. Update connection strings in backend config.

### SMS Gateway Integration

1. Sign up for an SMS provider (In here used SENDLK).
2. Obtain API keys and senderIDs.
3. Integrate in backend

## Usage

- **Patient App**: Download APK or run via Android Studio. Register, upload eye images for analysis, book appointments.
- **Admin Dashboard**: Access via browser at `localhost:8080` (or deployed URL). Login as admin to view/manage data.
- **Predictions**: Upload images through the app; results displayed with confidence scores from Azure Custom Vision.
- **Notifications**: Automatic SMS sent for appointment reminders or prediction alerts.

For detailed API docs, refer to Swagger (if integrated) or Postman collection in `/docs`.

## Contributing

Contributions are welcome! Please follow these steps:

1. Fork the repository.
2. Create a feature branch (`git checkout -b feature/AmazingFeature`).
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`).
4. Push to the branch (`git push origin feature/AmazingFeature`).
5. Open a Pull Request.

Ensure code follows best practices, includes tests, and updates documentation.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Contact

- **Maintainer**: moshdev2213
- **Email**: moshdev2213@gmail.com
- **GitHub Issues**: For bugs or feature requests, open an issue [here](https://github.com/moshdev2213/ICare-Medicals/issues).

Thank you for using ICare Medicals!💙