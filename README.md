# 🚆 BookMyTrain - IRCTC Console App

A **Java console-based railway booking system** simulating IRCTC features like user registration, login, train search, ticket booking, and cancellations. Ideal for learning **backend development** and OOP concepts in Java.

---

## ✨ Features
- 👤 User Registration & Login  
- 🔍 Search Trains by Source & Destination  
- 🎟 Book Tickets with Seat Availability Check  
- 📄 View My Tickets  
- ❌ Cancel Tickets  
- 🚂 View All Trains  
- 🚪 Logout  

---

## 🛠 Tech Stack
- **Language:** Java (JDK 23)  
- **IDE:** IntelliJ IDEA (or any Java IDE)  
- **Concepts:** OOP, Collections API, Scanner Input  
- **Data Handling:** Lists, Maps  

---

## 📂 Project Structure
BookMyTrain/
├── src/
│ ├── IRCTCAPP.java # Main application (entry point)
│ ├── User.java # User entity
│ ├── Train.java # Train entity
│ ├── Ticket.java # Ticket entity
│ ├── UserService.java # Handles user registration & login
│ ├── BookingService.java # Handles booking, search & cancellations
│ └── (other helper classes)
├── README.md
└── .gitignore


---

## ▶️ How to Run
1. Clone the repository:
```bash
git clone https://github.com/theyashshelar/BookMyTrain.git

2. Open the project in IntelliJ IDEA or any Java IDE.

3. Run IRCTCAPP.java from the src folder.

📸 Demo (Sample Console Output):

------ Welcome to IRCTC APP ------
1. Register
2. Login
3. Exit
Enter Your Choice: 1
Enter Username: yash123
Enter Password: 123
Enter Full Name: yash
Enter Contact: 1234567
Registration Successful

------ User Menu ------
1. Search Trains
2. Book Ticket
3. View My Tickets
4. Cancel Tickets
5. View All Trains
6. Logout

Booking Successful!
ticketId: 1 | Train: Rajdhani Express | Route: Delhi -> Nagpur | Seats: 2 | Booked By: yash

🚀 Future Improvements

Add Database support (MySQL/PostgreSQL)

Convert to a Spring Boot REST API

Create a React Frontend for real-time train booking

👨‍💻 Developed by Yash Shelar
📧 Email: yashshelar006@gmail.com

🔗 GitHub: theyashshelar
