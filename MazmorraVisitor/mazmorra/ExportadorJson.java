package mazmorra;

public class ExportadorJson implements Visitante
{
    private StringBuilder json = new StringBuilder();
    private boolean primero = true;

    public ExportadorJson() {
        json.append("[\n");
    }

    @Override
    public void visitarTesoro(Tesoro tesoro) {
        agregarComaSiNoEsPrimero();
        json.append("  {\n")
            .append("    \"tipo\": \"Tesoro\",\n")
            .append("    \"nombre\": \"").append(tesoro.getNombre()).append("\",\n")
            .append("    \"valor\": ").append(tesoro.getValor()).append("\n")
            .append("  }");
    }

    @Override
    public void visitarTrampa(Trampa trampa) {
        agregarComaSiNoEsPrimero();
        json.append("  {\n")
            .append("    \"tipo\": \"Trampa\",\n")
            .append("    \"descripcion\": \"").append(trampa.getDescripcion()).append("\",\n")
            .append("    \"danio\": ").append(trampa.getDanio()).append("\n")
            .append("  }");
    }

    @Override
    public void visitarMonstruo(Monstruo monstruo) {
        agregarComaSiNoEsPrimero();
        json.append("  {\n")
            .append("    \"tipo\": \"Monstruo\",\n")
            .append("    \"nombre\": \"").append(monstruo.getNombre()).append("\",\n")
            .append("    \"fuerza\": ").append(monstruo.getFuerza()).append("\n")
            .append("  }");
    }

    private void agregarComaSiNoEsPrimero() {
        if (primero) {
            primero = false;
        } else {
            json.append(",\n");
        }
    }

    public String exportar() {
        return json.append("\n]").toString();
    }
}
