package beans;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Used for REST services.
 * @author Calvin Novicki
 *
 * @param <T>
 */
@XmlRootElement(name="Response")
@XmlAccessorType(XmlAccessType.FIELD)
public class ResponseDataModel<T> extends ResponseModel {

	/**
	 * The data for the REST service. Generic.
	 */
	//@JsonInclude(Include.NON_NULL)
	private T data;
	
	/**
	 * Used for REST services to get all data. Generic.
	 */
	//@JsonInclude(Include.NON_NULL)
	private List<T> listData;
	
	/**
	 * Default constructor.
	 */
	public ResponseDataModel() {
		
		super(0, "");
		
		this.data = null;
	
	}
	
	/**
	 * Initializes with generic data.
	 * @param status
	 * @param message
	 * @param data
	 */
	public ResponseDataModel(int status, String message, T data) {
		
		super(status, message);
		
		this.data = data;
	
	}
	
	/**
	 * Initializes with generic data list.
	 * @param status
	 * @param message
	 * @param listData
	 */
	public ResponseDataModel(int status, String message, List<T> listData) {
		
		super(status, message);
		
		this.listData = listData;
		
	}

	//********************************************************************************//
	/*
	 * GETTERS AND SETTERS
	 */
	//********************************************************************************//
	
	public T getData() {
		
		return this.data;
	
	}
	
	public void setData(T data) {
		
		this.data = data;;

	}

	public List<T> getListData() {
	
		return listData;
	
	}

	public void setListData(List<T> listData) {
	
		this.listData = listData;
	
	}
	
}
