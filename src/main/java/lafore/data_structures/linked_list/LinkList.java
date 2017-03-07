package lafore.data_structures.linked_list;

/**
 * Класс LinkList содержит всего один элемент данных: ссылку на первый элемент списка. Ссылка хранится в поле с именем first. Это единственная информация
 * о местонахождении элементов, которая хранится в списке. Остальные элементы отслеживаются по цепочке ссылок next, начиная с элемента first.
 *
 * @author LinnykOleh
 */
public class LinkList {

	private Link first;

	public LinkList() {
		this.first = null;
	}

	private boolean isEmpty(){
		return first == null;
	}

	public void insertFirst(int iData, double dData){
		final Link newLink = new Link(iData, dData);
		newLink.next = first;
		first = newLink;
	}

	public Link deleteFirst(){
		final Link deletedFirst = first;
		if(!isEmpty()){
			first = first.next;
		}
		return deletedFirst;
	}

	public void displayLinkList(){
		Link link = first;
		while (link!= null){
			link.displayDataInfo();
			link = link.next;
		}
		System.out.println("");
	}

}
