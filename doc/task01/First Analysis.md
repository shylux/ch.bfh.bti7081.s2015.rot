## 1. Target Users
- Doctors
- Nurses
- Health visitors
- Receptionists
- Medical records staff

## 2. Key Features
- Patient management
- Appointment management
- Retrievals of important information (meetings, prescriptions, medication, instructions, responsible employees)
- Automatic appointment reminders (app/sms)
- "Health and Feel"-diary (receipt management)
- Report generation for hospital management
- Spital management

## 3. Critical Success Factors

### General (IT-Projects)
- Professional project management (from Wikipedia)
- Identifying dangers and risks (from Wikipedia)
- Detailed planning (from Wikipedia)
- Quality Managment and Controlling

### Project-Specific
- Data Protection Act - personal information is confidential
- Provide timely information to facilitate the treatment of patients
- Generate management information which allows health service managers to assess performance against local and government targets
- Privacy
- Availability
- Ease of use
- Documentation
- Training of staff

## 4 Potential System Components And Architecture

### Potential Module Architecture
![alt tag](https://github.com/shylux/ch.bfh.bti7081.s2015.rot/blob/master/doc/task01/Projekt_Aufwand.jpg)

### Components

#### General
- User (doctors, nurses, etc.) management (includes rights management)
- Patient management (includes relevant informations managment like addressess, names, etc.)
- Encryption

#### Subsystem for Receptionists
- Room / Cell management
- Appointment management

#### Subsystem for Clinical Report Staff
- Report generator

#### Subsystem for Doctors / Nurses
- Appointment management
- Receipt management
- "Carelog" - write entries for each session with the patient

### Architecture
- Client / Server Architecture
- Encryption
- Multiplattform (mobile, desktop)
- Database
- Authentication / Authorization
- Networking
