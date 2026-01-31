db.createCollection("Course", {
  validator: {
    $jsonSchema: {
      "bsonType": "object",
      "title": "Course",
      "required": ["title", "description", "teacherId", "status"],
      "properties": {
        "title": {
          "bsonType": "string"
        },
        "description": {
          "bsonType": "string"
        },
        "teacherId": {
          "bsonType": "string"
        },
        "status": {
          "bsonType": "object",
          "title": "object",
          "properties": {
            "DRAFT": {
              "enum": 
            },
            "PUBLISH": {
              "enum": 
            }
          }  
        }
      }  
    } 
  }
});
