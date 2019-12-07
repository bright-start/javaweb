package beanutilsTest;

public class A {
	private Integer id;
	private String name;
	private String text;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	@Override
	public String toString() {
		return "A [id=" + id + ", name=" + name + ", text=" + text + "]";
	}
	
}
