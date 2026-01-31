db.createCollection("Lesson", {
  validator: {
    $jsonSchema: {
      "bsonType": "object",
      "title": "Lesson",
      "required": ["course", "title", "contentUrl", "Course"],
      "properties": {
        "course": {
          "bsonType": "string"
        },
        "title": {
          "bsonType": "string"
        },
        "contentUrl": {
          "bsonType": "string"
        },
        "Course": {
          "bsonType": "objectId"
        }
      }  
    } 
  }
});
