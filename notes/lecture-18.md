### Lecture 18

```java
class Assignment {
  String name;
  double weight;
  IList<Submissions> subs;
  TeamSet teamset;
  Date due;
  LatenessPenalty penalty;
}

class Submission {
  Assignment whichAssn;
  Team team;
  Date timestamp;
  
  double grade();
}

class Team {
  IList<User> users;
  IList<Submission> subs;
}

class TeamSet {
  IList<Team> teams;
}

class User {
  String name;
  Image picture;
  IList<Submissions> subs;
  IList<Team> teams;
  IList<Course> courses;
  
  double gradeFor(Course c);
}

class Course {
  String name;
  IList<User> students;
  IList<User> staff;
  IList<Assignment> assgns;
}
```

