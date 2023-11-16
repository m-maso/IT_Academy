
db.createCollection('supplier', {
  validator: {
    $jsonSchema: {
      bsonType: 'object',
      title: 'supplier',
      required: ['first_name', 'last_name', 'NIF', 'supplier_address', 'phone', 'brands'],
      properties: {
        first_name: {
          bsonType: 'string'
        },
        last_name: {
          bsonType: 'string'
        },
        NIF: {
          bsonType: 'string'
        },
        supplier_address: {
          bsonType: 'object',
          title: 'object',
          required: ['sup_address_id', 'road', 'num', 'floor', 'door', 'city', 'postcode', 'country'],
          properties: {
            sup_address_id: {
              bsonType: 'objectId'
            },
            road: {
              bsonType: 'int'
            },
            num: {
              bsonType: 'int'
            },
            floor: {
              bsonType: 'int'
            },
            door: {
              bsonType: 'string'
            },
            city: {
              bsonType: 'string'
            },
            postcode: {
              bsonType: 'string'
            },
            country: {
              bsonType: 'string'
            }
          }
        },
        phone: {
          bsonType: 'string'
        },
        fax: {
          bsonType: 'string'
        },
        brands: {
          bsonType: 'array',
          items: {
            title: 'object',
            required: ['brand_id', 'name'],
            properties: {
              brand_id: {
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
db.supplier.createIndex({
  "NIF": 1
}, {
  name: "supplier_ix_1",
  unique: true
})

db.createCollection('customer', {
  validator: {
    $jsonSchema: {
      bsonType: 'object',
      title: 'customer',
      required: ['cust_id', 'first_name', 'last_name', 'cust_address', 'phone', 'email', 'register_date'],
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
        cust_address: {
          bsonType: 'object',
          title: 'object',
          required: ['cust_addresss_id', 'road', 'num', 'floor', 'door', 'city', 'postcode', 'country'],
          properties: {
            cust_addresss_id: {
              bsonType: 'objectId'
            },
            road: {
              bsonType: 'int'
            },
            num: {
              bsonType: 'int'
            },
            floor: {
              bsonType: 'int'
            },
            door: {
              bsonType: 'string'
            },
            city: {
              bsonType: 'string'
            },
            postcode: {
              bsonType: 'string'
            },
            country: {
              bsonType: 'string'
            }
          }
        },
        phone: {
          bsonType: 'string'
        },
        email: {
          bsonType: 'string'
        },
        register_date: {
          bsonType: 'timestamp'
        },
        recommended_cust_id: {
          bsonType: 'int'
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
      required: ['employee_id', 'first_name', 'last_name'],
      properties: {
        employee_id: {
          bsonType: 'objectId'
        },
        first_name: {
          bsonType: 'string'
        },
        last_name: {
          bsonType: 'string'
        }
      }
    }
  },
  autoIndexId: true
});

db.createCollection('invoice', {
  validator: {
    $jsonSchema: {
      bsonType: 'object',
      title: 'invoice',
      required: ['invoice_id', 'date', 'lenses', 'employee_id', 'cust_id'],
      properties: {
        invoice_id: {
          bsonType: 'objectId'
        },
        date: {
          bsonType: 'timestamp'
        },
        lenses: {
          bsonType: 'array',
          items: {
            title: 'object',
            required: ['lenses_id', 'left_lens', 'right_lens', 'frame', 'brand_id', 'price'],
            properties: {
              lenses_id: {
                bsonType: 'objectId'
              },
              left_lens: {
                bsonType: 'object',
                title: 'object',
                required: ['prescription', 'colour'],
                properties: {
                  prescription: {
                    bsonType: 'double'
                  },
                  colour: {
                    bsonType: 'string'
                  }
                }
              },
              right_lens: {
                bsonType: 'object',
                title: 'object',
                required: ['prescription', 'colour'],
                properties: {
                  prescription: {
                    bsonType: 'double'
                  },
                  colour: {
                    bsonType: 'symbol'
                  }
                }
              },
              frame: {
                bsonType: 'object',
                title: 'object',
                required: ['type', 'colour'],
                properties: {
                  type: {
                    enum: ['rimless', 'plastic', 'metal']
                  },
                  colour: {
                    bsonType: 'string'
                  }
                }
              },
              brand_id: {
                bsonType: 'int'
              },
              price: {
                bsonType: 'decimal'
              }
            }
          }
        },
        employee_id: {
          bsonType: 'objectId'
        },
        cust_id: {
          bsonType: 'objectId'
        }
      }
    }
  },
  autoIndexId: true
});
