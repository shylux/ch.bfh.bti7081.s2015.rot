## 1. Target Users
- Doctors (superuser)
- Nurses (privileged user)
- Health visitors (privileged user)
- Receptionists (appointment creation, user)
- Medical records staff (reports generation)

additional note:  management has no direct access to the system.

## 2. Key Features
- Management of personal information (Patientenverwaltung)
- Retrieval of important information (meetings, prescriptions, medication, instructions)
- Contact-information to the responsable person (questions, etc.)
- Creating and managing appointments
- Automatic appointment reminders (app/sms)
- "Health and Feel"-diary (Receipt-management)
- Report generation for hospital management
- Spital management

## 3. Critical Success Factors

### General
- Professional project management (from Wikipedia)
- Identifying dangers and risks (from Wikipedia)
- Detailed planning (from Wikipedia)

### Specific
- Data Protection Act - personal information is confidential
- Provide timely information to facilitate the treatment of patients
- Generate management information which allows health service managers to assess performance against local and government targets
- Project specific factors (privacy, availability, ease of use, documentation, training of staff)

## 4. Potential System Components And Architecture

### Components

#### General
- User (doctors, nurses, etc.) management including rights management
- Patient management including address management
- Encryption

####Subsystem for receptionists
- Room / cell management
- Appointment management

####Subsystem for Clinical Report Staff
- Report generator

####Subsystem for doctors / nurses
- Appointment management
- Receipt management
- "Carelog" - write entries for each session with the patient


### Architecture
- Client / Server Architecture
- Encryption
- Multiplattform (Mobile, Desktop)
- Database
- Authentication / Authorization
- Networking
