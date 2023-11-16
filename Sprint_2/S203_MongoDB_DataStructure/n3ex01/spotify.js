
db.createCollection('user', {
  validator: {
    $jsonSchema: {
      bsonType: 'object',
      title: 'user',
      required: ['user_id', 'email', 'password', 'username', 'birthday', 'gender', 'user_type'],
      properties: {
        user_id: {
          bsonType: 'objectId'
        },
        email: {
          bsonType: 'string'
        },
        password: {
          bsonType: 'string'
        },
        username: {
          bsonType: 'string'
        },
        birthday: {
          bsonType: 'date'
        },
        gender: {
          enum: ['Woman', 'Man']
        },
        country: {
          bsonType: 'string'
        },
        postcode: {
          bsonType: 'string'
        },
        user_type: {
          enum: ['free', 'premium']
        }
      }
    }
  },
  autoIndexId: true
});

db.createCollection('premium_user_subscription', {
  validator: {
    $jsonSchema: {
      bsonType: 'object',
      title: 'premium_user_subscription',
      required: ['subscription_id', 'user_id', 'start_date', 'payment_method'],
      properties: {
        subscription_id: {
          bsonType: 'objectId'
        },
        user_id: {
          bsonType: 'objectId'
        },
        start_date: {
          bsonType: 'date'
        },
        renovation_date: {
          bsonType: 'date'
        },
        payment_method: {
          enum: ['credit_card', 'paypal']
        },
        credit_card: {
          bsonType: 'array',
          items: {
            title: 'object',
            required: ['credit_card_id', 'card_number', 'expiration_date', 'CVV_code'],
            properties: {
              credit_card_id: {
                bsonType: 'objectId'
              },
              card_number: {
                bsonType: 'int'
              },
              expiration_date: {
                bsonType: 'string'
              },
              CVV_code: {
                bsonType: 'int'
              }
            }
          }
        },
        paypal: {
          bsonType: 'array',
          items: {
            title: 'object',
            required: ['paypal_id', 'username'],
            properties: {
              paypal_id: {
                bsonType: 'objectId'
              },
              username: {
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

db.createCollection('user_payment', {
  validator: {
    $jsonSchema: {
      bsonType: 'object',
      title: 'user_payment',
      required: ['user_payment_id', 'date', 'order_number', 'total_payments', 'payed_subscription_id'],
      properties: {
        user_payment_id: {
          bsonType: 'objectId'
        },
        date: {
          bsonType: 'date'
        },
        order_number: {
          bsonType: 'int'
        },
        total_payments: {
          bsonType: 'int'
        },
        payed_subscription_id: {
          bsonType: 'objectId'
        }
      }
    }
  },
  autoIndexId: true
});

db.user_payment.createIndex({

}, {
  name: "user_payment_ix_1",
  unique: true
})
db.createCollection('playlist', {
  validator: {
    $jsonSchema: {
      bsonType: 'object',
      title: 'playlist',
      required: ['playlist_id', 'createdby_user_id', 'title', 'total_songs_num', 'type', 'creation_date'],
      properties: {
        playlist_id: {
          bsonType: 'objectId'
        },
        createdby_user_id: {
          bsonType: 'objectId'
        },
        title: {
          bsonType: 'string'
        },
        total_songs_num: {
          bsonType: 'int'
        },
        type: {
          enum: ['active', 'deleted']
        },
        creation_date: {
          bsonType: 'timestamp'
        },
        deletion_date: {
          bsonType: 'timestamp'
        }
      }
    }
  },
  autoIndexId: true
});

db.createCollection('add_song', {
  validator: {
    $jsonSchema: {
      bsonType: 'object',
      title: 'add_song',
      required: ['playlist_id', 'song_id', 'date_added_song', 'addedby_user_id'],
      properties: {
        playlist_id: {
          bsonType: 'objectId'
        },
        song_id: {
          bsonType: 'objectId'
        },
        date_added_song: {
          bsonType: 'timestamp'
        },
        addedby_user_id: {
          bsonType: 'objectId'
        }
      }
    }
  }
});

db.createCollection('song', {
  validator: {
    $jsonSchema: {
      bsonType: 'object',
      title: 'song',
      required: ['song_id', 'title', 'length', 'num_reproductions', 'album_id'],
      properties: {
        song_id: {
          bsonType: 'objectId'
        },
        title: {
          bsonType: 'string'
        },
        length: {
          bsonType: 'double'
        },
        num_reproductions: {
          bsonType: 'int'
        },
        album_id: {
          bsonType: 'objectId'
        }
      }
    }
  },
  autoIndexId: true
});

db.createCollection('album', {
  validator: {
    $jsonSchema: {
      bsonType: 'object',
      title: 'album',
      required: ['album_id', 'title', 'publication_year', 'artist_id'],
      properties: {
        album_id: {
          bsonType: 'objectId'
        },
        title: {
          bsonType: 'string'
        },
        publication_year: {
          bsonType: 'int'
        },
        cover: {
          bsonType: 'binData'
        },
        artist_id: {
          bsonType: 'objectId'
        }
      }
    }
  },
  autoIndexId: true
});

db.createCollection('artist', {
  validator: {
    $jsonSchema: {
      bsonType: 'object',
      title: 'artist',
      required: ['artist_id', 'name', 'portrait', 'related_artist'],
      properties: {
        artist_id: {
          bsonType: 'objectId'
        },
        name: {
          bsonType: 'string'
        },
        portrait: {
          bsonType: 'binData'
        },
        related_artist: {
          bsonType: 'objectId'
        }
      }
    }
  },
  autoIndexId: true
});

db.createCollection('favourite_songs', {
  validator: {
    $jsonSchema: {
      bsonType: 'object',
      title: 'favourite_songs',
      required: ['user_id', 'song_id'],
      properties: {
        user_id: {
          bsonType: 'objectId'
        },
        song_id: {
          bsonType: 'objectId'
        }
      }
    }
  },
  autoIndexId: true
});

db.createCollection('favourtie_albums', {
  validator: {
    $jsonSchema: {
      bsonType: 'object',
      title: 'favourtie_albums',
      required: ['user_id', 'album_id'],
      properties: {
        user_id: {
          bsonType: 'objectId'
        },
        album_id: {
          bsonType: 'objectId'
        }
      }
    }
  },
  autoIndexId: true
});

db.createCollection('favourite_artists', {
  validator: {
    $jsonSchema: {
      bsonType: 'object',
      title: 'favourite_artists',
      required: ['user_id', 'artist_id'],
      properties: {
        user_id: {
          bsonType: 'objectId'
        },
        artist_id: {
          bsonType: 'objectId'
        }
      }
    }
  },
  autoIndexId: true
});
