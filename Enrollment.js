db.createCollection("Enrollment", {
  validator: {
    $jsonSchema: {
      "bsonType": "object",
      "title": "Enrollment",
      "required": ["studentId", "courseId", "enrolledAt", "Course"],
      "properties": {
        "studentId": {
          "bsonType": "string"
        },
        "courseId": {
          "bsonType": "string"
        },
        "enrolledAt": {
          "bsonType": "date"
        },
        "Course": {
          "bsonType": "objectId"
        }
      }  
    } 
  }
});
