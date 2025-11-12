package model;

public class VideoPublicado {
	private final String canalId;
	private final String titulo;
	private final String url;
	private final long publicadoEnMillis;

	public VideoPublicado(String canalId, String titulo, String url, long publicadoEnMillis) {
		this.canalId = canalId;
		this.titulo = titulo;
		this.url = url;
		this.publicadoEnMillis = publicadoEnMillis;
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

	public long getPublicadoEnMillis() {
		return publicadoEnMillis;
	}

}
