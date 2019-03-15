package devTool.Panels;

import java.util.LinkedList;

import javax.swing.AbstractListModel;

public class LinkedListModel<T> extends AbstractListModel<T> {
	private static final long serialVersionUID = -2965087386044462994L;
	private LinkedList<T> list;

	public LinkedListModel(LinkedList<T> list) {
		if (list != null)
			this.list = list;
		else
			this.list = new LinkedList<T>();
	}

	public void changeList(LinkedList<T> list) {
		if (list == null)
			list = new LinkedList<T>();
		this.list = list;
		fireContentsChanged(this, 0, this.getSize());
	}

	public LinkedListModel<T> push(T element) {
		int index = list.size();
		list.add(element);
		fireIntervalAdded(this, index, index);
		return this;
	}

	public LinkedListModel<T> removeElement(T element) {
		int index = list.indexOf(element);
		list.remove(element);
		fireIntervalRemoved(this, index, index);
		return this;
	}

	public LinkedListModel<T> removeElementAt(int index) {
		list.remove(index);
		fireIntervalRemoved(this, index, index);
		return this;
	}

	@Override
	public int getSize() {
		return list.size();
	}

	@Override
	public T getElementAt(int index) {
		return list.get(index);
	}

}
