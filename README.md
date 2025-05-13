# MovieMania: A Java Swing Movie and TV Show Information System

<div align="center">
  <img src="https://user-images.githubusercontent.com/your-username/path-to-your-logo/MovieManiaLogo.jpg" alt="MovieMania Logo" width="300px">
  <h3>Your personal entertainment discovery and management app</h3>
</div>

## 🎬 Table of Contents

- [Overview](#overview)
- [Features](#features)
- [System Architecture](#system-architecture)
- [Technology Stack](#technology-stack)
- [Database Schema](#database-schema)
- [Installation and Setup](#installation-and-setup)
- [Usage Guide](#usage-guide)
- [API Integration](#api-integration)
- [Code Structure](#code-structure)
- [Component Breakdown](#component-breakdown)
- [Sequence Diagrams](#sequence-diagrams)
- [Security Features](#security-features)
- [Future Enhancements](#future-enhancements)
- [Contributing](#contributing)
- [License](#license)

## 📋 Overview

MovieMania is a comprehensive Java desktop application built with Swing that enables users to discover, explore, and manage their favorite movies and TV shows. The application connects to The Movie Database (TMDB) API to fetch up-to-date information on movies, TV shows, actors, and production companies, while maintaining user preferences and favorites in a local MySQL database.

### Core Functionality

MovieMania helps users:
- Search for movies, TV shows, actors, and production companies
- Browse content by genre
- Stay updated with upcoming movie releases
- Maintain a personalized list of favorite movies and TV shows
- Access detailed information including release dates, overviews, and trailers

<div align="center">
  <img src="https://github.com/Arshnoor-Singh-Sohi/MovieMania/blob/main/src/hall.jpg" alt="MovieMania Screenshot" width="600px">
  <p><i>The application features a sleek, user-friendly interface for browsing entertainment content</i></p>
</div>

## ✨ Features

### User Management
- **Account Creation**: New users can register with a username, password, and personal information
- **Authentication**: Secure login system for registered users
- **Account Management**: Options to change password or delete account
- **Password Recovery**: Forgot password functionality with OTP verification

### Content Discovery
- **Search Functionality**: Search for movies, TV shows, actors, and production companies
- **Genre Exploration**: Browse content categorized by genres
- **Upcoming Releases**: View list of upcoming movie releases
- **Dynamic Content Loading**: Real-time data fetching from TMDB API

### Personal Management
- **Favorites**: Add movies and TV shows to a personal favorites list
- **Favorites Management**: View and remove items from favorites list

### Content Details
- **Comprehensive Information**: View detailed information about movies and TV shows
- **Release Dates**: Check when content was or will be released
- **Overviews**: Read descriptions of movies and TV shows
- **Trailers**: Direct links to watch trailers on YouTube

### User Interface
- **Responsive Design**: Full-screen application that adapts to different screen sizes
- **Image Carousel**: Welcome screen with sliding show of popular movie posters
- **Intuitive Navigation**: Easy-to-use menu system for accessing different features

## 🏗️ System Architecture

MovieMania follows a three-tier architecture pattern:

```
┌───────────────┐     ┌───────────────┐     ┌───────────────┐
│  Presentation │     │    Business   │     │     Data      │
│     Layer     │────►│     Layer     │────►│    Access     │
│  (Java Swing) │     │   (Services)  │     │    Layer      │
└───────────────┘     └───────────────┘     └───────────────┘
        │                                           │
        │                                           │
        ▼                                           ▼
┌───────────────┐                         ┌───────────────┐
│   User Input  │                         │ MySQL Database│
│  & Displays   │                         │   TMDB API    │
└───────────────┘                         └───────────────┘
```

### Layer Details:

1. **Presentation Layer**:
   - Java Swing GUI components (JFrames, JPanels, JLabels, JButtons, etc.)
   - Custom-designed UI elements for content display
   - Image handling and rendering

2. **Business Layer**:
   - User authentication and validation logic
   - Content search and filtering mechanisms
   - Favorites management logic
   - API interaction service

3. **Data Access Layer**:
   - Database connection and query execution (via `DBLoader`)
   - API request handling and response parsing
   - Local data storage management

## 🛠️ Technology Stack

### Programming Language
- **Java**: Core language used for application development

### GUI Framework
- **Java Swing**: For creating the desktop application interface

### Database
- **MySQL**: Relational database for storing user data and preferences
- **JDBC**: Java Database Connectivity for database interactions

### External API
- **TMDB API**: The Movie Database API for fetching movie and TV show information
- **Unirest**: HTTP client library for making API requests

### JSON Parsing
- **org.json.simple**: Library for parsing JSON responses from the API

### Image Processing
- **ImageIO**: For reading and processing images
- **BufferedImage**: For image manipulation and scaling

### Development Tools
- **NetBeans IDE**: Integrated Development Environment used for building the application

## 🗃️ Database Schema

The application uses a MySQL database named `movie_mania` with the following tables:

### `login_users` Table
Stores information about registered users.

| Column      | Type         | Description                    |
|-------------|--------------|--------------------------------|
| username    | VARCHAR(50)  | Primary Key, User's login name |
| password    | VARCHAR(50)  | User's password                |
| first_name  | VARCHAR(50)  | User's first name              |
| last_name   | VARCHAR(50)  | User's last name               |

### `mv_list` Table
Stores user's favorite movies.

| Column      | Type         | Description                    |
|-------------|--------------|--------------------------------|
| id          | INT          | Movie ID from TMDB             |
| username    | VARCHAR(50)  | Foreign Key to login_users     |
| name        | VARCHAR(255) | Movie title                    |
| photo       | VARCHAR(255) | Path to movie poster           |

### `tv_list` Table
Stores user's favorite TV shows.

| Column      | Type         | Description                    |
|-------------|--------------|--------------------------------|
| id          | INT          | TV Show ID from TMDB           |
| username    | VARCHAR(50)  | Foreign Key to login_users     |
| name        | VARCHAR(255) | TV Show title                  |
| photo       | VARCHAR(255) | Path to TV show poster         |

### `generated_otp` Table
Temporarily stores OTPs for password recovery.

| Column      | Type         | Description                    |
|-------------|--------------|--------------------------------|
| otp         | INT          | One-time password              |

## 📥 Installation and Setup

### Prerequisites
- JDK 8 or higher
- MySQL Server 5.7 or higher
- NetBeans IDE 8.2 or higher (or any Java IDE)
- Internet connection for API access

### Database Setup
1. Install MySQL Server on your machine
2. Create a new database named `movie_mania`
3. Import the provided SQL script to create the necessary tables:
   ```sql
   CREATE TABLE login_users (
       username VARCHAR(50) PRIMARY KEY,
       password VARCHAR(50) NOT NULL,
       first_name VARCHAR(50) NOT NULL,
       last_name VARCHAR(50) NOT NULL
   );

   CREATE TABLE mv_list (
       id INT NOT NULL,
       username VARCHAR(50) NOT NULL,
       name VARCHAR(255) NOT NULL,
       photo VARCHAR(255) NOT NULL,
       PRIMARY KEY (id, username),
       FOREIGN KEY (username) REFERENCES login_users(username)
   );

   CREATE TABLE tv_list (
       id INT NOT NULL,
       username VARCHAR(50) NOT NULL,
       name VARCHAR(255) NOT NULL,
       photo VARCHAR(255) NOT NULL,
       PRIMARY KEY (id, username),
       FOREIGN KEY (username) REFERENCES login_users(username)
   );

   CREATE TABLE generated_otp (
       otp INT NOT NULL
   );
   ```

### API Key Setup
1. Sign up for a free account at [The Movie Database](https://www.themoviedb.org/)
2. Generate an API key from your account settings
3. Open `DBLoader.java` and update the connection details:
   ```java
   Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/movie_mania", "your_username", "your_password");
   ```
4. Open all files that use the TMDB API and update the API key:
   ```java
   String api_key = "your_api_key";
   ```

### Application Setup
1. Clone the repository:
   ```
   git clone https://github.com/Arshnoor-Singh-Sohi/MovieMania.git
   ```
2. Open the project in NetBeans IDE or your preferred Java IDE
3. Ensure all required libraries are added to the project:
   - JSON Simple
   - Unirest HTTP
   - MySQL Connector/J
4. Build the project
5. Run the application by executing the `LOGIN_PAGE.java` file

## 🎮 Usage Guide

### Login and Registration
1. **Start the Application**: Run the program to open the login page
2. **Register New Account**: Click "REGISTER" to create a new account
   - Fill in first name, last name, username, and password
   - Confirm password by entering it again
   - Click "SIGN UP" to complete registration
3. **Login**: Enter your username and password, then click "LOGIN"
4. **Forgot Password**: Click "FORGOT PASSWORD?" to reset your password
   - Enter your username
   - Generate and enter the OTP
   - Create and confirm a new password

### Home Page Navigation
The home page provides access to all main features through button navigation:
- **UPCOMING MOVIES**: View soon-to-be-released films
- **SEARCH MOVIES**: Search for specific movies
- **SEARCH TV SHOWS**: Search for specific TV shows
- **SEARCH ACTORS**: Search for actors and their works
- **SEARCH COMPANY**: Search for production companies
- **GENRE MOVIES LIST**: Browse movies by genre
- **GENRE TV LIST**: Browse TV shows by genre
- **FAVOURITE MOVIES**: View your saved favorite movies
- **FAVOURITE TV SHOWS**: View your saved favorite TV shows

### User Profile Management
Access user options through the dropdown menu in the top-right corner:
- **CHANGE PASSWORD**: Update your account password
- **DELETE ACCOUNT**: Permanently remove your account
- **LOG OUT**: Sign out of the application

### Searching Content
1. Click on the desired search option (Movies, TV Shows, Actors, Company)
2. Enter your search term in the text field
3. Click "SEARCH" to retrieve results
4. Browse through the results displayed with posters and information

### Managing Favorites
1. When viewing movies or TV shows, click "ADD TO MY LIST" to add to favorites
2. To view favorites, click "FAVOURITE MOVIES" or "FAVOURITE TV SHOWS" from the home page
3. To remove from favorites, click "REMOVE" on any item in your favorites list

### Exploring Content Details
- Click "OVERVIEW" to read a description of the content
- Click "WATCH TRAILER" to open the trailer on YouTube
- Release dates are displayed with each movie or TV show

### Genre Exploration
1. Click "GENRE MOVIES LIST" or "GENRE TV LIST" on the home page
2. Select a genre from the table
3. Click "SEARCH" to view content in that genre
4. Browse through the results to discover new content

## 🔌 API Integration

MovieMania integrates with The Movie Database (TMDB) API to fetch real-time information about movies, TV shows, actors, and production companies.

### API Endpoints Used

| Endpoint | Purpose | Implementation |
|----------|---------|----------------|
| `/search/movie` | Search for movies by name | `SEARCH_MOVIES.java` |
| `/search/tv` | Search for TV shows by name | `SEARCH_TV_SHOWS.java` |
| `/search/person` | Search for actors | `SEARCH_PEOPLE.java` |
| `/search/company` | Search for production companies | `SEARCH_COMPANY.java` |
| `/genre/movie/list` | Get list of movie genres | `GENRE_MOVIE_LIST.java` |
| `/genre/tv/list` | Get list of TV show genres | `GENRE_TV_LIST.java` |
| `/discover/movie` | Get movies by genre | `Search_Movie_By_Category.java` |
| `/discover/tv` | Get TV shows by genre | `SEARCH_TVSHOWS_BY_CATEGORY.java` |
| `/movie/upcoming` | Get upcoming movies | `UPCOMING_MOVIES.java` |

### Example API Request

```java
String api_key = "980d96176457a6e65b8bc282bcadccd4";
String movie_name = search_movies_tf1.getText();
String movie_query = movie_name.replace(" ", "%20");
HttpResponse<String> response = Unirest.get("https://api.themoviedb.org/3/search/movie?api_key=" + api_key + "&language=en-US&query=" + movie_query + "&page=1&include_adult=false").asString();

if (response.getStatus() == 200) {
    String res = response.getBody();
    JSONParser parser = new JSONParser();
    JSONObject jsonobject = (JSONObject) parser.parse(res);
    JSONArray jsonarray = (JSONArray) jsonobject.get("results");
    
    // Process results...
}
```

### Image Handling

The application fetches and displays poster images from TMDB's image CDN:

```java
URL url = new URL("https://image.tmdb.org/t/p/original/" + poster_path);
BufferedImage img = ImageIO.read(url);
Image im = img.getScaledInstance(obj.photo.getWidth(), obj.photo.getHeight(), BufferedImage.SCALE_SMOOTH);
obj.photo.setIcon(new ImageIcon(im));
```

## 📁 Code Structure

The project follows a structured file organization pattern:

```
MovieMania/
├── src/
│   ├── User Management/
│   │   ├── LOGIN_PAGE.java
│   │   ├── REGISTER_PAGE.java
│   │   ├── FORGOT_PASSWORD.java
│   │   ├── CHANGE_PASSWORD.java
│   │   └── DELETE_ACCOUNT.java
│   ├── Home and Navigation/
│   │   ├── HOME_TESTING.java
│   │   ├── welcome.java
│   │   └── PanelSlider42.java
│   ├── Movie Features/
│   │   ├── SEARCH_MOVIES.java
│   │   ├── UPCOMING_MOVIES.java
│   │   ├── GENRE_MOVIE_LIST.java
│   │   ├── Search_Movie_By_Category.java
│   │   └── FAV_MOVIES.java
│   ├── TV Show Features/
│   │   ├── SEARCH_TV_SHOWS.java
│   │   ├── GENRE_TV_LIST.java
│   │   ├── SEARCH_TVSHOWS_BY_CATEGORY.java
│   │   └── FAV_SHOWS.java
│   ├── Other Search Features/
│   │   ├── SEARCH_PEOPLE.java
│   │   ├── SEARCH_COMPANY.java
│   │   └── MULTI_SEARCH.java
│   ├── Design Components/
│   │   ├── SEARCH_MOVIES_DESIGN.java
│   │   ├── SEARCH_TV_SHOWS_DESIGN.java
│   │   ├── SEARCH_PEOPLE_DESIGN.java
│   │   ├── SEARCH_COMPANY_DESIGN.java
│   │   ├── FAV_SHOWS_DESIGN.java
│   │   ├── UPCOMING_MOVIES_DESIGN.java
│   │   └── moviedesign.java
│   ├── Utilities/
│   │   ├── DBLoader.java
│   │   ├── Global.java
│   │   └── category.java
│   └── Resources/
│       ├── *.jpg (Image resources)
│       └── *.png (Icon resources)
```

## 🧩 Component Breakdown

### Key Classes and Their Functions

#### User Management

1. **LOGIN_PAGE**
   - Handles user authentication
   - Connects to the database to verify credentials
   - Provides navigation to registration and password recovery

```java
private void login_bt1ActionPerformed(java.awt.event.ActionEvent evt) {
    try {
        String u = username_tf1.getText();
        String p = jp1.getText();
        
        if(!u.isEmpty() && !p.isEmpty()) {            
            ResultSet rs = DBLoader.executeSQL("select * from login_users where username='"+u+"' and password='"+p+"'");
            if(rs.next()) {
                f_name = rs.getString("first_name");
                l_name = rs.getString("last_name");
                JOptionPane.showMessageDialog(this, "LOGIN SUCCESSFULL!!!");
                Global.username = "WELCOME  "+f_name+"  "+l_name;
                Global.user = u;
                dispose();
                welcome obj = new welcome();
                obj.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "INVALID USERNAME OR PASSWORD");
            }
        } else {
            JOptionPane.showMessageDialog(this, "ALL FIELDS ARE MANDATORY");
        }
    } catch(Exception ex) {
        ex.printStackTrace();
    }
}
```

2. **REGISTER_PAGE**
   - Allows new users to create accounts
   - Validates user input
   - Stores new user information in the database

3. **FORGOT_PASSWORD**
   - Implements a three-step password recovery process:
     1. Username verification
     2. OTP generation and verification
     3. Password reset
   - Uses a temporary OTP storage in the database

#### Content Discovery and Management

1. **HOME_TESTING**
   - Central dashboard after login
   - Provides buttons to navigate to all features
   - Handles user account management options via dropdown

```java
public HOME_TESTING() {
    initComponents();
    
    Dimension d = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
    setSize(d.width, d.height);
    
    bg.setSize(d.width, d.height);
    ImageIcon img2 = new ImageIcon("src/hall.jpg");
    Image im2 = img2.getImage().getScaledInstance(bg.getWidth(), bg.getHeight(), Image.SCALE_SMOOTH);
    bg.setIcon(new ImageIcon(im2));
    bg.setBounds(0, 0, d.width, d.height);
    
    welcome.setBounds(0,70,d.width,40);
    welcome.setText(Global.username);
    welcome.setForeground(new java.awt.Color(222, 222, 222));
        
    setVisible(true);
}
```

2. **SEARCH_MOVIES**
   - Allows searching for movies by title
   - Displays search results with posters, titles, and release dates
   - Provides options to add movies to favorites
   - Links to movie trailers on YouTube

```java
void search() {
    mainpanel.repaint();
    mainpanel.removeAll();
    jScrollPane1.setVisible(false);

    String api_key = "980d96176457a6e65b8bc282bcadccd4";
    try {
        String m_name = search_movies_tf1.getText();
        String mo_name = m_name.replace(" ", "%20");
        HttpResponse<String> response = Unirest.get("https://api.themoviedb.org/3/search/movie?api_key=" + api_key + "&language=en-US&query=" + mo_name + "&page=1&include_adult=false").asString();

        if (response.getStatus() == 200) {
            jScrollPane1.setVisible(true);
            String res = response.getBody();
            
            JSONParser parser = new JSONParser();
            JSONObject jsonobject = (JSONObject) parser.parse(res);
            JSONArray jsonarray = (JSONArray) jsonobject.get("results");
            
            int x = 10, y = 10, j = 0;
            
            for (int i = 0; i < jsonarray.size(); i++) {
                JSONObject movie_detail = (JSONObject) jsonarray.get(i);
                
                long id = (Long) movie_detail.get("id");
                String title = (String) movie_detail.get("title");
                String overview = (String) movie_detail.get("overview");
                String release_date = (String) movie_detail.get("release_date");
                String poster_path = (String) movie_detail.get("poster_path");
                
                if (poster_path != null) {
                    // Create and configure UI components for each result
                    // ...
                }
            }
        }
    } catch(Exception ex) {
        ex.printStackTrace();
    }
}
```

3. **GENRE_MOVIE_LIST**
   - Fetches and displays movie genres from TMDB
   - Allows users to select a genre to explore
   - Uses a custom table model to display genres

```java
void genre() {
    String api_key = "980d96176457a6e65b8bc282bcadccd4";
    try {
        HttpResponse<String> response = Unirest.get("https://api.themoviedb.org/3/genre/movie/list?api_key="+api_key+"&language=en-US").asString();
        
        if(response.getStatus()==200) {
            String res = response.getBody();
            
            JSONParser parser = new JSONParser();
            JSONObject jsonobject = (JSONObject) parser.parse(res);
            JSONArray jsonarray = (JSONArray) jsonobject.get("genres");
            
            for(int i=0; i<jsonarray.size(); i++) {
                JSONObject genre_detail = (JSONObject) jsonarray.get(i);
                
                long id = (long) genre_detail.get("id");
                String name = (String) genre_detail.get("name");
                
                al.add(new category(id, name));
            }
        }
    } catch(Exception ex) {
        ex.printStackTrace();
    }
}
```

4. **FAV_MOVIES**
   - Displays the user's favorite movies
   - Provides option to remove movies from favorites
   - Fetches movie posters from TMDB

```java
void get_data() {
    mainpanel.repaint();
    mainpanel.removeAll();
    jScrollPane1.setVisible(false);
    try {
        ResultSet rs = DBLoader.executeSQL("select * from mv_list where username='"+Global.user+"'");

        int x = 10, y = 10, j = 0;

        while (rs.next()) {
            j++;
            FAV_SHOWS_DESIGN obj = new FAV_SHOWS_DESIGN();

            jScrollPane1.setVisible(true);
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String photo = rs.getString("photo");

            obj.name.setText(name);

            obj.remove.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ResultSet rs1 = DBLoader.executeSQL("select * from mv_list where id=" + id+" and username='"+Global.user+"'");
                    try {
                        if (rs1.next()) {
                            rs1.deleteRow();
                            get_data();
                        } else {
                            JOptionPane.showMessageDialog(null, "ALREADY DELETED");
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            });

            URL url = new URL("https://image.tmdb.org/t/p/original/"+photo);
            BufferedImage img = ImageIO.read(url);
            Image im = img.getScaledInstance(obj.photo.getWidth(), obj.photo.getHeight(), BufferedImage.SCALE_SMOOTH);
            obj.photo.setIcon(new ImageIcon(im));

            obj.setBounds(10, y, 500, 200);
            mainpanel.add(obj);
            y = y + 210;

            repaint();
            mainpanel.repaint();
            obj.repaint();
        }
        int ss = 210 * j;
        mainpanel.setPreferredSize(new Dimension(510, ss));
    } catch (Exception ex) {
        ex.printStackTrace();
    }
}
```

#### Utility Classes

1. **DBLoader**
   - Central database connection manager
   - Executes SQL queries and returns results
   - Uses JDBC to connect to MySQL

```java
public static ResultSet executeSQL(String sql) {
    try {
        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/movie_mania", "root", "Asus1052");
        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = stmt.executeQuery(sql);
        return rs;
    } catch(Exception ex) {
        ex.printStackTrace();
        return null;
    }
}
```

2. **Global**
   - Stores global variables accessible throughout the application
   - Primarily used to store the current user's information

```java
public class Global {
    public static String username="";
    public static String user="";
}
```

#### UI Components

1. **PanelSlider42**
   - Custom component used for the image carousel on the welcome screen
   - Implements smooth transitions between panels
   - Uses threading for animation effects

2. **Design Classes**
   - Custom JPanel extensions for displaying content:
     - `SEARCH_MOVIES_DESIGN`
     - `SEARCH_TV_SHOWS_DESIGN`
     - `SEARCH_PEOPLE_DESIGN`
     - `FAV_SHOWS_DESIGN`
   - Each design class has specific layout and components for displaying content

## 📊 Sequence Diagrams

### User Login Sequence

```
┌─────┐          ┌──────────┐          ┌────────┐          ┌──────────┐
│User │          │LOGIN_PAGE│          │DBLoader│          │Database  │
└──┬──┘          └────┬─────┘          └───┬────┘          └────┬─────┘
   │    Enter Credentials │                 │                   │
   │ ─────────────────────>                 │                   │
   │                      │                 │                   │
   │                      │ executeSQL(query)                   │
   │                      │ ────────────────>                   │
   │                      │                 │  Execute Query    │
   │                      │                 │ ─────────────────>│
   │                      │                 │                   │
   │                      │                 │   Return Result   │
   │                      │                 │ <─────────────────│
   │                      │  Return ResultSet                   │
   │                      │ <────────────────                   │
   │                      │                 │                   │
   │     Show Result      │                 │                   │
   │ <─────────────────────                 │                   │
   │                      │                 │                   │
   │                      │                 │                   │
┌──┴──┐          ┌────┴─────┐          ┌───┴────┐          ┌────┴─────┐
│User │          │LOGIN_PAGE│          │DBLoader│          │Database  │
└─────┘          └──────────┘          └────────┘          └──────────┘
```

### Search Movies Sequence

```
┌─────┐          ┌─────────────┐          ┌──────────┐          ┌──────┐
│User │          │SEARCH_MOVIES│          │Unirest   │          │TMDB  │
└──┬──┘          └──────┬──────┘          └────┬─────┘          └──┬───┘
   │    Enter Search Term│                      │                   │
   │ ─────────────────────>                     │                   │
   │                     │                      │                   │
   │                     │   get(search_url)    │                   │
   │                     │ ─────────────────────>                   │
   │                     │                      │   API Request     │
   │                     │                      │ ──────────────────>
   │                     │                      │                   │
   │                     │                      │   JSON Response   │
   │                     │                      │ <──────────────────
   │                     │   Return Response    │                   │
   │                     │ <─────────────────────                   │
   │                     │                      │                   │
   │                     │ Parse JSON Response  │                   │
   │                     │ ─────────────────────┐                   │
   │                     │ <─────────────────────┘                  │
   │                     │                      │                   │
   │                     │ Create & Display UI  │                   │
   │                     │ ─────────────────────┐                   │
   │                     │ <─────────────────────┘                  │
   │                     │                      │                   │
   │    Display Results  │                      │                   │
   │ <─────────────────────                     │                   │
   │                     │                      │                   │
┌──┴──┐          ┌──────┴──────┐          ┌────┴─────┐          ┌──┴───┐
│User │          │SEARCH_MOVIES│          │Unirest   │          │TMDB  │
└─────┘          └─────────────┘          └──────────┘          └──────┘
```

### Add to Favorites Sequence

```
┌─────┐          ┌─────────────┐          ┌────────┐          ┌──────────┐
│User │          │Content View │          │DBLoader│          │Database  │
└──┬──┘          └──────┬──────┘          └───┬────┘          └────┬─────┘
   │   Click Add to List │                    │                    │
   │ ─────────────────────>                   │                    │
   │                     │                    │                    │
   │                     │  Check if Exists   │                    │
   │                     │ ───────────────────>                    │
   │                     │                    │  Query Database    │
   │                     │                    │ ───────────────────>
   │                     │                    │                    │
   │                     │                    │   Return Result    │
   │                     │                    │ <───────────────────
   │                     │  Return ResultSet  │                    │
   │                     │ <───────────────────                    │
   │                     │                    │                    │
   │                     │ If not exists:     │                    │
   │                     │ moveToInsertRow()  │                    │
   │                     │ updateFields()     │                    │
   │                     │ insertRow()        │                    │
   │                     │ ───────────────────>                    │
   │                     │                    │  Insert into DB    │
   │                     │                    │ ───────────────────>
   │                     │                    │                    │
   │                     │                    │  Confirm Insert    │
   │                     │                    │ <───────────────────
   │                     │                    │                    │
   │  Success Message    │                    │                    │
   │ <─────────────────────                   │                    │
   │                     │                    │                    │
┌──┴──┐          ┌──────┴──────┐          ┌───┴────┐          ┌────┴─────┐
│User │          │Content View │          │DBLoader│          │Database  │
└─────┘          └─────────────┘          └────────┘          └──────────┘
```

## 🔒 Security Features

While MovieMania implements basic security measures, it is important to note that this is a demonstration project and would require additional security enhancements for production use.

### Current Security Implementations

1. **Password Confirmation**
   - During registration and password changes, users must confirm their password
   - Prevents accidental typos in passwords

2. **Account Deletion Confirmation**
   - Requires password verification before account deletion
   - Prevents accidental account removal

3. **Password Recovery**
   - Implements a secure OTP-based password recovery system
   - Generated OTP is required to reset the password

### Security Considerations for Production

1. **Password Hashing**
   - Currently, passwords are stored in plaintext
   - In a production environment, passwords should be hashed using a secure algorithm like bcrypt

2. **Input Validation**
   - Additional input validation should be implemented to prevent SQL injection
   - Special character handling should be improved

3. **HTTPS Communication**
   - API requests should use HTTPS for secure data transmission
   - Database connections should be secured

4. **Session Management**
   - Implement proper session management for user authentication
   - Add session timeouts and renewal mechanisms

## 🚀 Future Enhancements

MovieMania has potential for several enhancements that could improve functionality and user experience:

1. **Content Recommendations**
   - Implement an algorithm to recommend movies and TV shows based on user preferences
   - Suggest content similar to what the user has favorited

2. **User Reviews and Ratings**
   - Allow users to write reviews for movies and TV shows
   - Implement a rating system for users to rate content

3. **Social Features**
   - Friend connections between users
   - Ability to share favorites and recommendations

4. **Advanced Filtering**
   - Filter content by release year, rating, etc.
   - Implement multi-criteria search

5. **Offline Mode**
   - Cache frequently accessed content for offline viewing
   - Implement a sync mechanism for when connection is restored

6. **Mobile Application**
   - Develop a mobile version using technologies like React Native or Flutter
   - Ensure cross-platform compatibility

7. **Performance Optimizations**
   - Implement image caching to reduce bandwidth usage
   - Optimize database queries for faster response

## 👥 Contributing

Contributions to MovieMania are welcome! If you'd like to contribute, please follow these steps:

1. Fork the repository
2. Create a new branch for your feature (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

### Development Guidelines

- Follow Java coding standards and conventions
- Document new code with appropriate comments
- Test thoroughly before submitting pull requests
- Update the README if necessary

## 📄 License

This project is licensed under the MIT License - see the LICENSE file for details.

---

## 📞 Contact

Arshnoor Singh Sohi - [GitHub Profile](https://github.com/Arshnoor-Singh-Sohi)

Project Link: [https://github.com/Arshnoor-Singh-Sohi/MovieMania](https://github.com/Arshnoor-Singh-Sohi/MovieMania)

---

<div align="center">
  <p>Built with ❤️ by Arshnoor Singh Sohi</p>
</div>
