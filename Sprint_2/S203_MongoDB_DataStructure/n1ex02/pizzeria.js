
db.createCollection('customer', {
  validator: {
    $jsonSchema: {
      bsonType: 'object',
      title: 'customer',
      required: ['cust_id', 'first_name', 'last_name', 'address', 'postcode', 'phone', 'town_city', 'province'],
      properties: {
        cust_id: {
          bsonType: 'objectId'
        },
        first_name: {
          bsonType: 'string'
        },
        last_name: {
          bsonType: 'string'
        },
        address: {
          bsonType: 'object',
          title: 'object',
          required: ['road', 'num', 'floor', 'door'],
          properties: {
            road: {
              bsonType: 'string'
            },
            num: {
              bsonType: 'int'
            },
            floor: {
              bsonType: 'int'
            },
            door: {
              bsonType: 'string'
            }
          }
        },
        postcode: {
          bsonType: 'string'
        },
        phone: {
          bsonType: 'string'
        },
        town_city: {
          bsonType: 'objectId'
        },
        province: {
          bsonType: 'objectId'
        }
      }
    }
  },
  autoIndexId: true
});

db.createCollection('town_city', {
  validator: {
    $jsonSchema: {
      bsonType: 'object',
      title: 'town_city',
      required: ['town_city_id', 'name', 'province_id'],
      properties: {
        town_city_id: {
          bsonType: 'objectId'
        },
        name: {
          bsonType: 'string'
        },
        province_id: {
          bsonType: 'objectId'
        }
      }
    }
  },
  autoIndexId: true
});

db.createCollection('province', {
  validator: {
    $jsonSchema: {
      bsonType: 'object',
      title: 'province',
      required: ['province_id', 'name'],
      properties: {
        province_id: {
          bsonType: 'objectId'
        },
        name: {
          bsonType: 'string'
        }
      }
    }
  },
  autoIndexId: true
});

db.createCollection('employee', {
  validator: {
    $jsonSchema: {
      bsonType: 'object',
      title: 'employee',
      required: ['employee_id', 'first_name', 'last_name', 'NIF', 'phone', 'job_title', 'pizzeria_id'],
      properties: {
        employee_id: {
          bsonType: 'objectId'
        },
        first_name: {
          bsonType: 'string'
        },
        last_name: {
          bsonType: 'string'
        },
        NIF: {
          bsonType: 'string'
        },
        phone: {
          bsonType: 'string'
        },
        job_title: {
          enum: ['delivery_driver', 'cook']
        },
        pizzeria_id: {
          bsonType: 'objectId'
        }
      }
    }
  },
  autoIndexId: true
});
db.employee.createIndex({
  "NIF": 1
}, {
  name: "employee_ix_1",
  unique: true
})

db.createCollection('invoice', {
  validator: {
    $jsonSchema: {
      bsonType: 'object',
      title: 'invoice',
      required: ['invoice_id', 'date_hour', 'delivery_type', 'product_id', 'qty_by_prod_type', 'total_price', 'cust_id', 'pizzeria_id', 'home_delivery_id'],
      properties: {
        invoice_id: {
          bsonType: 'objectId'
        },
        date_hour: {
          bsonType: 'timestamp'
        },
        delivery_type: {
          enum: ['home_delivery', 'click&collect']
        },
        product_id: {
          bsonType: 'array',
          items: {
            bsonType: 'objectId'
          }
        },
        qty_by_prod_type: {
          bsonType: 'array',
          items: {
            bsonType: 'int'
          }
        },
        total_price: {
          bsonType: 'decimal'
        },
        cust_id: {
          bsonType: 'objectId'
        },
        pizzeria_id: {
          bsonType: 'objectId'
        },
        home_delivery_id: {
          bsonType: 'objectId'
        }
      }
    }
  },
  autoIndexId: true
});

db.createCollection('pizzeria', {
  validator: {
    $jsonSchema: {
      bsonType: 'object',
      title: 'pizzeria',
      required: ['pizzeria_id', 'address', 'postcode', 'town_city', 'province'],
      properties: {
        pizzeria_id: {
          bsonType: 'objectId'
        },
        address: {
          bsonType: 'object',
          title: 'object',
          required: ['road', 'num', 'floor', 'door'],
          properties: {
            road: {
              bsonType: 'string'
            },
            num: {
              bsonType: 'int'
            },
            floor: {
              bsonType: 'int'
            },
            door: {
              bsonType: 'string'
            }
          }
        },
        postcode: {
          bsonType: 'string'
        },
        town_city: {
          bsonType: 'objectId'
        },
        province: {
          bsonType: 'objectId'
        }
      }
    }
  },
  autoIndexId: true
});

db.createCollection('product', {
  validator: {
    $jsonSchema: {
      bsonType: 'object',
      title: 'product',
      required: ['product_id', 'name', 'quantity', 'price', 'product_category'],
      properties: {
        product_id: {
          bsonType: 'objectId'
        },
        name: {
          bsonType: 'string'
        },
        description: {
          bsonType: 'string'
        },
        image: {
          bsonType: 'binData'
        },
        quantity: {
          bsonType: 'int'
        },
        price: {
          bsonType: 'decimal'
        },
        product_category: {
          enum: ['pizza', 'hamburger', 'drink']
        },
        pizza: {
          bsonType: 'objectId'
        }
      }
    }
  },
  autoIndexId: true
});

db.createCollection('pizza_categories', {
  validator: {
    $jsonSchema: {
      bsonType: 'object',
      title: 'pizza_categories',
      required: ['pizza_categ_id', 'name'],
      properties: {
        pizza_categ_id: {
          bsonType: 'objectId'
        },
        name: {
          bsonType: 'string'
        }
      }
    }
  },
  autoIndexId: true
});

db.createCollection('home_delivery', {
  validator: {
    $jsonSchema: {
      bsonType: 'object',
      title: 'home_delivery',
      required: ['home_delivery_id', 'delivered_date_time', 'employee'],
      properties: {
        home_delivery_id: {
          bsonType: 'objectId'
        },
        delivered_date_time: {
          bsonType: 'timestamp'
        },
        employee: {
          bsonType: 'objectId'
        }
      }
    }
  },
  autoIndexId: true
});
