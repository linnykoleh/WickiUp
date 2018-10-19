package com.linnyk.jpa.tree;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@NamedQueries({
		/*UNION ALL ?*/
		@NamedQuery(name = FolderEntity.FIND_FOLDERS_CHILDREN, query = "from FolderEntity f where f.parentFolder.id = :childId"),
		@NamedQuery(name = FolderEntity.FIND_LEAFS_CHILDREN, query = "from LeafEntity l where l.folder.id = :folderId")
})
@Entity
@Table(name = "EFOREX_FOLDER_DATA_SERIES")
public class FolderEntity {

	public static final String FIND_FOLDERS_CHILDREN = "FolderEntity.findFoldersChildren";
	public static final String FIND_LEAFS_CHILDREN = "FolderEntity.findLeafsChildren";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "NAME")
	private String name;

	@JoinColumn(name = "FOLDER_PARENT_FK")
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	private FolderEntity parentFolder;

}

