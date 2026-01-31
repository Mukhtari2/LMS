db.createCollection("Assignment", {
  validator: {
    $jsonSchema: {
      "bsonType": "object",
      "title": "Assignment",
      "required": ["courseId", "title", "description", "dueDate", "Course"],
      "properties": {
        "courseId": {
          "bsonType": "string"
        },
        "title": {
          "bsonType": "string"
        },
        "description": {
          "bsonType": "string"
        },
        "dueDate": {
          "bsonType": "string"
        },
        "Course": {
          "bsonType": "objectId"
        }
      }  
    } 
  }
});
