## Chapter 12, XML mapping files

The following algorithm can be considered as the simplified logic for obtaining the metadata for the persistence unit:
1. Process the annotations. The set of entities, mapped superclasses and embedded objects is discovered by looking for the @Entity, @MappedSuperclass and @Embeddable annotations (set E). The resulting metadata in set C. Missing metadata is left empty.
2. Add classes defined in XML. These are added to E. if one already exists in E, we apply the overriding rules for class-level metadata found in the mapping file. The added or adjusted class-level metadata go to C.
3. Add attribute mappings defined in XML. E > fields and properties in the mapping file and try to add the method metadata to C. If the field or property exists, the overriding rules for attribute-level metadata are applied.
4. Apply defaults. The classes, attribute mappings, and other settings that have not yet been defined are assigned values. 

- *XML config is not necessary.* 
- The XML config is specified in orm_2_0_xsd (for JPA 2.0).
- The root element of the mapping file is called **<entity-mappings .. />**
    - The subelements of entity-mappings can be organized in four main scoping and functional groups:
        1. Persistence unit defaults
        2. Mapping files defaults
        3. Queries and generators
        4. Managed classes an mappings
        

### Disabling annotations
- **xml-mapping-metadata-complete:**  All annotations in the entire persistence unit will be ignored, and only the mapping files in the persistence unit will be considered as the total set of provided metadata. Only entities, mapped superclasses and embedded objects that have entries in a mapping file will be added to the persistence unit. The element needs to be only one of the mapping files if there are multiple mapping files in the persistence unit. 
    - Empty subelement of the **persistence-unit-metadata**, which is the first subelement of the **entity-mappings**.
- **metadata-complete:** An attribute on the entity, mapped-superclass and embeddable elements. All annotations on the specified class and on any fields or properties in the class will be ignored.
    - Identifier must be mapped and all relationships must be specified with their corresponding cardinality mappings inside the entity element. 
   ```
   <entity-mappings>
    ...
    <entity class="examples.model.Employee"
        metadata-complete="true">
      <attributes>
        <id name="id"/>
      </attributes>
    </entity-mapping>
    
### Persistence unit defaults
- Persistence unit metadata can only be specified in the XML mapping file. 
- **persistence-unit-defaults:** The element that encloses all the persistence unit level defaults in the aptly.
    - The other subelement of the **persistence-unit-metadata**. 
- Six settings can be configured to have default values for the persistence unit:
 1. schema
    - Can be overwritten by:
        - file defaults mapping
        - schema attribute
        - schema defined by annotation
 2. catalog
    - see schema
 3. delimited-identifiers
    - Causes database table, schema and column identifiers used in the database to be delimited when sent to the database.
 4. access
    ````
    <persistence-unit-defaults>
            <access>FIELD or PROPERTY</access>
    ````
    - Does not affect any of the managed classes with annotations
    - Can be overridden by:
        - Access element in mapping file defaults
        - Access attribute on mapping file
        - @Access annotations
 5. cascade-persist
    ````
    <cascade-persist/>
    ````
    - Cannot be overridden
    - Persistence by reachability
 6. entity listeners
    - Default entity-listeners
    - Zero to more entity listeners
    - Override by
        - exclude-default-listeners
        - @ExcludeDefaultListeners
        
 
#### Queries and generators
- **sequence-generator:** Can be used to define a new generator or override a generator of the same name that is defined by a @SequenceGenerator annotation in any other class in the persistence unit. 
    - It can be specified either at the global level as a subelement of *entity-mapping*, at the entity level as a subelement of *entity* or at the field or property level as a subelement of the id mapping element.
        ````
        <entity-mappings>
        ...
            <sequence-generator name="empGen" sequence-name="empSeq"/>
            ...
        </entity-mappings>
        ````
- **table-generator:** Denies a generator that uses a table to generate identifiers. This element might define a new generator or it might be overriding a generator defined @TableGenerator annotation
    ````
    <entity-mappings>
        ...
        <table-generator name="empGen" table="ID_GEN" pk-column-value="EmpId"/>.
        ...
    </entity-mappings>    
    ````
- **named-query:** 
    - Subelement of entity-mappings or entity.
    - Keyed by its name
    ````
    <entity-mappings>
        ...
        <named-query name="findEmpsWithName">
            <query> SELECT e FROM Employee e WHERE e.name LIKE :empName </query>
            <hint name="javax.persistence.cacheRetrieveMode" value="CacheRetrieveMode.BYPASS"/>
        </named-query>        
        <named-query name="findEmpsWithName">
            <query> <![CDATA[SELECT e FROM Employee e WHERE e.salary > :salary]]></query>
            <hint name="javax.persistence.cacheRetrieveMode" value="CacheRetrieveMode.BYPASS"/>
        </named-query>
    </entity-mappings>        
    ````
- **named-native-query:** 
    - can appear as subelement of entity-mappings or entity.
    ````
    <named-native-query name="findAllManagers"
                        result-class="examples.model.Employee">
        <query> ...
        </query>
    </named-native-query>
    ````
- **sql-result-set-mapping:** Native queries to instruct the persistence provider how to map the result.
    - Result can be mapped as one or more entity types, projection data or a combination of the two. 
    - Can define a new mapping or override an existing one. When overriding an annotation, you will override the entire annotation.
   ```
        <sql-result-set-mapping name="DepartmentSummary">
            <entity-result entity-class="examples.model.Department">
                <field-result name="name" column="DEPT_NAME"/>
            </entity-result>
            <entity-result entity-class="examples.model.Employee"/>
            <column-result name="TOT_EMP"/>
            <column-result name="AVG_SAL"/>
        </sql-result-set-mapping>    
    ``` 
   