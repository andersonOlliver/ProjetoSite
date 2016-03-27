package br.com.bb.intranet.supermt.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import br.com.bb.intranet.supermt.model.Noticia;
import br.com.bb.intranet.supermt.repository.Noticias;

@FacesConverter(forClass = Noticia.class)
public class NoticiasConverter implements Converter{

	@Inject
	private Noticias noticias;
	
	@Override
	public Object getAsObject(FacesContext context,
			UIComponent component, String value){
		Noticia retorno = null;
		
		if(value != null && !"".equals(value)){
			retorno = this.noticias.porId(new Long(value));
		}
		
		return retorno;
	}
	
	@Override
	public String getAsString(FacesContext context,
			UIComponent component, Object value){
		if(value != null) {
			Noticia noticia = ((Noticia) value);
			return noticia.getIdNoticia() == null ? null 
					: noticia.getIdNoticia().toString();
		}
		return null;
	}
}
