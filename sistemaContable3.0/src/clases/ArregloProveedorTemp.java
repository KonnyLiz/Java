package clases;

public class ArregloProveedorTemp {

	// instance variables

		private String descripcion;
		private String contacto;
		private String ruc;
		private Boolean  editar;






		public ArregloProveedorTemp(String descripcion, String contacto,
				String ruc, Boolean editar) {
			super();
			this.descripcion = descripcion;
			this.contacto = contacto;
			this.ruc = ruc;
			this.editar = editar;
		}



		public String getDescripcion() {
			return descripcion;
		}
		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}
		public String getContacto() {
			return contacto;
		}
		public void setContacto(String contacto) {
			this.contacto = contacto;
		}
		public String getRuc() {
			return ruc;
		}
		public void setRuc(String ruc) {
			this.ruc = ruc;
		}
		public Boolean getEditar() {
			return editar;
		}
		public void setEditar(Boolean editar) {
			this.editar = editar;
		}




}
