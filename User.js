db.createCollection("User", {
  validator: {
    $jsonSchema: {
      "bsonType": "object",
      "title": "User",
      "required": ["name", "email", "password"],
      "properties": {
        "name": {
          "bsonType": "string"
        },
        "email": {
          "bsonType": "string"
        },
        "password": {
          "bsonType": "string"
        },
        "role": {
          "bsonType": "object",
          "title": "object",
          "properties": {
            "ADMIN": {
              "enum": 
            },
            "STUDENT": {
              "enum": 
            },
            "TEACHER": {
              "enum": 
            }
          }  
        }
      }  
    } 
  }
});
