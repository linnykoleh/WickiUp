## Chapter 4, Object-Relational Mapping

### Persistence annotations 
***Can be on class, method and field***

- **Logical annotations:** Entity model from an object modeling view.
- **Physical annotation:** Concrete data model in the database, tables, columns, constraints ao.  

#### Access mode
- **Field access:** Protected, package or private. @Id is persistent identifier, field access should be assumed.
- **Property access:** Access via getter and setter, public or protected methods. @Id on getter method.
- **Mixed access:** @Access(AccessType.FIELD/PROPERTY), @Transient for the corresponding field or property to the one being made persistent, to avoid that the same state is being persistent twice.


### Mapping to table
- **@Table(name="x", schema/catalog="x")**
- **@Basic:** Documentation purpose, being persistent, basic mappings. 
- **@Column(name="nameofcolumn")**
- **@FetchType.EAGER  /LAZY:** EAGER is default, LAZY can be used when you want data to be only fetched when object is being used. 

### Large objects 
- @Lob
- CLOBs character []
- BLOBs binary []

### Enumerated types
- @Enumerated(EnumType.ORDINAL) default
- @Enumerated(EnumType.STRING) not recommended


### Temporal types
- java.sql.Date / Time / TimeStamp
- java.util.Date / Calendar
	- For these two types @Temporal is necessary. 
	- @Temporal(TemporalType.DATE/TIME/TIMESTAMP)


### Transient state
- The transient modifier can be used to not serialize an attribute.
- @Transient annotation can be used when value should be retained across serialization. 


### Primary key
- Primary keys are insertable, not nullable or updatable. 
- @GeneratedValue(strategy=GenerationType.ENUM)
- After flush or completed transaction, the id can be accessed. 
- ***GenerationType***:
	- *AUTO:* a generation strategy for development of prototyping.
	- *TABLE:* generate identifiers by using a database table. Allows storing multiple different identifier sequences for different entities within the same table.<br>
	Database table with two columns:
		- 1: String type used to identify the sequence
		- 2: Integer type id sequence the last identifier 
		- @TableGenerator(name="x") to specify the table details.
	- *SEQUENCE:* id generation via sequences.
	- *IDENTITY:* autonumber column. Whenever a row is inserted into the table, the identity column will get a unique identifier assigned to it. 
		- less efficient
		- not available until after commit or completed transaction. 
		- no generator annotation because it has to be defined as part of the database schema definition for the primary key column of the entity. 
		- Generation cannot be shared across multi-entities. 


### Relationships
- *Directionality:* When each entity points to the other, the relationship is *bidirectional*. If only one entity has a pointer to the other, the relationship is *unidirectional*. 
- *Cardinality:* Many entities exist on each side of the same relationship instance. 
- *Ordinality:* Optionality of a relationship. Cardinality being a range instead of a simple value.




***Single-valued association***
- Many-to-one: @ManyToOne, @JoinColumn(name="X_ID")
- One-to-one: @OneToOne(mappedBy="reference") 
	- the value of mappedBy is the name of the attribute in the owning entity that points back to the inverse entity. 
	- @JoinColumn(name="X_ID"), goes on the mapping of the entity that is mapped to the table containing the join column, or the owner of the relationship.



***Collection-valued association***
- One-to-many: When an entity is associated with a Collection of other entities. Almost never the owning side, the inverse side. `mappedBy` is used for this relationship.
- Many-to-many: Use a third table to associate the two entitiy types, a *join table*. This table consists of two foreign key or join columns to refer to each of the two entity types in the relationship. 
	- @JoinTable annotation is used to configure the join table for the relationship. 
	- @JoinTable(name="EMP_PROJ", joinColumns=@JoinColumn(name="EMP\_ID"), inverseJoinColumns=@JoinColumn(name="PROJ\_ID"))


### FetchType
- (fetch=FetchType.LAZY)
- (fetch=FetchType.EAGER) default

### Embedded objects
- An object that is dependent on an entity for its identity. 
- @Embeddable: Serves to distinguish the class from other regular Java types. Once a class has this annotation, its fields and properties will be persistable as part of an entity. 
- @Embedded: Can be used optionally to indicate that it is an embedded mapping in entity class.
- @AttributeOverride: for each attribute of the embedded object that we want to override in the entity. 
	- @AttributeOverrides{(@AttributeOverride(name ="state", column=@Column(name="PROVINCE"))}  
