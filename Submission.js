db.createCollection("Submission", {
  validator: {
    $jsonSchema: {
      "bsonType": "object",
      "title": "Submission",
      "required": ["assignment", "studentId", "fileUrl", "answeredAt", "Assignment"],
      "properties": {
        "assignment": {
          "bsonType": "string"
        },
        "studentId": {
          "bsonType": "string"
        },
        "fileUrl": {
          "bsonType": "string"
        },
        "answeredAt": {
          "bsonType": "date"
        },
        "grade": {
          "bsonType": "date"
        },
        "feedback": {
          "bsonType": "date"
        },
        "submittedAt": {
          "bsonType": "date"
        },
        "Assignment": {
          "bsonType": "objectId"
        }
      }  
    } 
  }
});
