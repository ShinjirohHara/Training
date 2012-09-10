package ch19.ex19_01;


public class LinkedList {
	
	private LinkedList next = null;
	private Object value = null;
	
	/**
	 * 引数なしコンストラクタ
	 */
	public LinkedList(){
	}
	
	
	/**
	 * コンストラクタ。
	 * valueを要素として１つ持つリストを生成します。
	 * 
	 * @param value
	 */
	public LinkedList(Object value) {
		this.value = value;
	}
	
	/**
	 * コンストラクタ
	 * valuesでリストを初期化します.
	 * 
	 * @param values
	 */
	public LinkedList(Object[] values) {
		add(values);
	}
	
	/**
	 * リストの最後にvalueを追加します。
	 * 
	 * @param value 追加する要素
	 */
	public void add(Object value) {
		if (this.value == null) {
			this.value = value;
		} else if (this.next == null){
			this.next = new LinkedList(value);
		} else {
			this.next.add(value);
		}
	}
	
	
	/**
	 * Listの先頭要素を取得します。
	 * 
	 * @return
	 */
	public Object getValue() {
		return value;
	}
	
	/**
	 * リストの最後にvaluesを追加します。
	 * 
	 * @param values
	 */
	public void add(Object... values) {
		for (int i = 0; i < values.length; i ++) {
			add(values[i]);
		}
	}
	
	/**
	 * リストからvalueを削除します。
	 * 同じオブジェクトが追加されていた場合、最初に見つかったオブジェクトにのみ削除します。
	 * valueがリストに存在しない場合、nullを返します。
	 * 
	 * @param value
	 * @return 削除されたオブジェクト
	 */
	public Object remove(Object value) {
		
		if (value == null) return null;
		
		if (value.equals(this.value)) {
			this.value = null;
			return value;
		} else if (this.next != null){
			return next.remove(value);
		} else {
			return null;
		}
	}
	
	
	/**
	 * リストのサイズを返します。
	 * 
	 * @return リストのサイズ
	 */
	public int getSize() {
		if (next == null) {
			if (value == null) {
				return 0;
			} else {
				return 1;
			}
		} else {
			if (value == null) {
				return next.getSize() + 1;
			} else {
				return next.getSize();
			}
		}
	}
	
	/**
	 * 文字列化します。
	 */
	public String toString() {
		if (next == null) {
			if (value == null) {
				return null;
			} else {
				return value.toString();
			}
		} else {
			if(value == null) {
				return next.toString();
			} else {
				return value.toString()+","+next.toString();
			}
		}
	}

}
