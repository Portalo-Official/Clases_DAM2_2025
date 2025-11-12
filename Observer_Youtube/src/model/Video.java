package model;

public class Video {
	private final String canalId;
	private final String titulo;
	private final String url;

	public Video(String canalId, String titulo, String url) {
		this.canalId = canalId;
		this.titulo = titulo;
		this.url = url;
	}

	public String getCanalId() {
		return canalId;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getUrl() {
		return url;
	}
}
