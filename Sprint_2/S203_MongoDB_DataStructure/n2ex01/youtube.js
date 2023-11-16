
db.createCollection('user', {
  validator: {
    $jsonSchema: {
      bsonType: 'object',
      title: 'user',
      required: ['user_id', 'username', 'email', 'password', 'date_of_birth', 'gender'],
      properties: {
        user_id: {
          bsonType: 'objectId'
        },
        username: {
          bsonType: 'string'
        },
        email: {
          bsonType: 'string'
        },
        password: {
          bsonType: 'string'
        },
        date_of_birth: {
          bsonType: 'string'
        },
        gender: {
          enum: ['Woman', 'Man']
        },
        postcode: {
          bsonType: 'string'
        },
        country: {
          bsonType: 'string'
        }
      }
    }
  },
  autoIndexId: true
});

db.createCollection('video', {
  validator: {
    $jsonSchema: {
      bsonType: 'object',
      title: 'video',
      required: ['publishedby_user_id', 'video_id', ' title', 'size', 'filename', 'length', 'state', 'date_hour_published'],
      properties: {
        publishedby_user_id: {
          bsonType: 'objectId'
        },
        video_id: {
          bsonType: 'objectId'
        },
        title: {
          bsonType: 'string'
        },
        description: {
          bsonType: 'string'
        },
        size: {
          bsonType: 'double'
        },
        filename: {
          bsonType: 'string'
        },
        length: {
          bsonType: 'double'
        },
        thumbnail: {
          bsonType: 'binData'
        },
        num_reproductions: {
          bsonType: 'int'
        },
        num_likes: {
          bsonType: 'int'
        },
        num_dislikes: {
          bsonType: 'int'
        },
        state: {
          enum: ['public', 'hidden', 'private']
        },
        date_hour_published: {
          bsonType: 'timestamp'
        },
        tag: {
          bsonType: 'array',
          items: {
            title: 'object',
            required: ['tag_id', 'name'],
            properties: {
              tag_id: {
                bsonType: 'objectId'
              },
              name: {
                bsonType: 'string'
              }
            }
          }
        }
      }
    }
  },
  autoIndexId: true
});

db.createCollection('playlist', {
  validator: {
    $jsonSchema: {
      bsonType: 'object',
      title: 'playlist',
      required: ['playlist_id', 'name', 'creation_date', 'state', 'createdby_user_id', 'added_video_id'],
      properties: {
        playlist_id: {
          bsonType: 'objectId'
        },
        name: {
          bsonType: 'string'
        },
        creation_date: {
          bsonType: 'timestamp'
        },
        state: {
          enum: ['public', 'private']
        },
        createdby_user_id: {
          bsonType: 'objectId'
        },
        added_video_id: {
          bsonType: 'objectId'
        }
      }
    }
  },
  autoIndexId: true
});

db.createCollection('channel', {
  validator: {
    $jsonSchema: {
      bsonType: 'object',
      title: 'channel',
      required: ['channel_id', 'name', 'creation_date', 'createdby_user_id'],
      properties: {
        channel_id: {
          bsonType: 'objectId'
        },
        name: {
          bsonType: 'string'
        },
        description: {
          bsonType: 'string'
        },
        creation_date: {
          bsonType: 'timestamp'
        },
        createdby_user_id: {
          bsonType: 'objectId'
        }
      }
    }
  },
  autoIndexId: true
});

db.createCollection('comment', {
  validator: {
    $jsonSchema: {
      bsonType: 'object',
      title: 'comment',
      required: ['comment_id', 'comment_text', 'date_hour', 'madeby_user_id'],
      properties: {
        comment_id: {
          bsonType: 'objectId'
        },
        comment_text: {
          bsonType: 'string'
        },
        date_hour: {
          bsonType: 'timestamp'
        },
        madeby_user_id: {
          bsonType: 'objectId'
        }
      }
    }
  },
  autoIndexId: true
});

db.createCollection('rate_comment', {
  validator: {
    $jsonSchema: {
      bsonType: 'object',
      title: 'rate_comment',
      required: ['ratedby_user_id', 'comment_id', 'date_hour'],
      properties: {
        ratedby_user_id: {
          bsonType: 'objectId'
        },
        comment_id: {
          bsonType: 'objectId'
        },
        date_hour: {
          bsonType: 'timestamp'
        },
        like: {
          bsonType: 'string'
        },
        dislike: {
          bsonType: 'string'
        }
      }
    }
  },
  autoIndexId: true
});

db.createCollection('subscribe_channel', {
  validator: {
    $jsonSchema: {
      bsonType: 'object',
      title: 'subscribe_channel',
      required: ['user_id', 'channel_id'],
      properties: {
        user_id: {
          bsonType: 'objectId'
        },
        channel_id: {
          bsonType: 'objectId'
        }
      }
    }
  },
  autoIndexId: true
});

db.createCollection('rate_video', {
  validator: {
    $jsonSchema: {
      bsonType: 'object',
      title: 'rate_video',
      required: ['user_id', 'video_id', 'date_time_rating'],
      properties: {
        user_id: {
          bsonType: 'objectId'
        },
        video_id: {
          bsonType: 'objectId'
        },
        date_time_rating: {
          bsonType: 'timestamp'
        },
        like: {
          bsonType: 'string'
        },
        dislike: {
          bsonType: 'string'
        }
      }
    }
  },
  autoIndexId: true
});

