package br.com.bb.intranet.supermt.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import br.com.bb.intranet.supermt.model.Usuario;
import br.com.bb.intranet.supermt.repository.Usuarios;

@FacesConverter(forClass = Usuario.class)
public class UsuarioConverter implements Converter {

	@Inject
	private Usuarios usuarios;

	@Override
	public Object getAsObject(FacesContext context,
			UIComponent component, String value) {
		Usuario retorno = null;

		if (value != null && !"".equals(value)) {
			retorno = this.usuarios.porId(new Long(value));
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			return ((Usuario) value).getIdUsuario().toString();
		}
		return null;
	}
}
