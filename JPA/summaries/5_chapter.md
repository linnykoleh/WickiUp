## Chapter 5, Collection mapping

- Objects that can be mapped as collection:
    1. Entities
    2. Embeddables
    3.Basic types
    
***Support for collections fof embeddable and simple types was added in JPA 2.0.***

- **@ElementCollection(target="x")** 
 - **@Embeddable**
 - **@CollectionTable**
    Default naming is referencing entity `_` entity attribute. The default name of the join column is referencing entity `_` name of primary key.
- @AttributeOverride overrides the column names.


- **Collection:** superinterface, most common used
- **Set:** will prevent duplicates
- **List:** user defined order
- **Map**


- `@OrderBy`
    - Default is ASC and order by primary key.
- `@OrderColumn(name="x")`
    - Name defaults in name of entity attribute "_ORDER"
    - Order column stored depends on mapping. Usually the table that stores the entity or the element being stored.
    - One-to-many - Stores in the 'many'
    - Element collection - Stores in the collection table
    - Many-to-many - stores in the join table
    
    
#### Maps
- Associate key with arbitrary value object
- Key rules are:
    - They must be comparable an respond to hashCode() and equals() method.
    - Need to be unique 
    - Must not change while object is acting as a key.
- When keys are entities only foreign key is stored in the table.
- **@MapKeyValue:** Indicate the column in the collection table that stores the basic key. If the name is not specified, the key is stored in a column named after the mapped collection attribute and "_KEY".


- **@Enumerated**
- **@MapKeyEnumerated**
- **@MapKeyTemporal**
- **@MapKeyColumn**
- **@MapKey:** designate the attribute of the target entity that is being keyed on. Default is id, which is a type of int or Integer.


- Map can only be used on one side of the many-to-many relationship

#### Embeddables as key
- Embeddables are not full fledged entities, not queryable by itself and the identity is not defined.
- Stored in the table referred to by mapping.
- Multiple columns contributing to the primary key.

#### Keying by entity
- Advantage of keying by entity type is that the entity instances are globally unit (within the persistence context).
- Key will be stored in the table referred to by the mapping
- **@MapKeyJoinColumn:** Override the join column defaults for an entity key.
- **@MapKeyClass:** Should be used whenever the key class cannot be deducted from the attribute definition or the other mapping data.


- Use **@MapKeyClass** and targetEntity/targetClass elements of the relationship and element collection mappings to specify the classes when an untyped Map is used.
- Use **@MapKey** with one-to-many or many-to-many relationship Map that is keyed on an attribute of the target entity.
- Use **@Column** to override the column storing the values of an element collection of basic types.
- Use **@MapKeyColumn** to override the column storing the keys when keyed by a basic type.
- Use **@MapKeyTemporal** or **@MapKeyEnumerated** if you need to further qualify a basic key that is a temporal or enumerated type.
- Use **@AttributeOverride** with a `key.` or `value.` prefix to override the column of an embeddable attribute type that is a Map key or a value.

****See page 126 for Summary of  mapping a map***


- In a List there are no guarantees in order if it is not specified. 
- `@OrderBy` is the best approach compared to a list.
- The preferred and most efficient use of a Map is to use an attribute of the target object as a key, making a Map of entities keyed by a basic attribute type the most common and useful.
- Avoid using embedded objects in a Map, because their identity is typically not defined.