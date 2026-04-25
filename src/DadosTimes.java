
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author henri
 */

//Classe responsável por simular um banco de dados interno, armazenando times e seus jogadores
public class DadosTimes {
    
    
    public static Map<String, List<String>> getJogadoresTimes(){
        //Cria um map com o nome de cada time incluído no sistema e sua respectiva lista de jogadores
        Map<String, List<String>> jogadoresTimes = new HashMap<>();
        
        //Adiciona um time ao Map usando seu nome como referência e criando uma List com os seus respectivos jogadores
        jogadoresTimes.put("Flamengo", new ArrayList<>(List.of(
            "Rossi", "Danilo", "Vitão", "Léo Pereira", "Alex Sandro", "Everton Araújo", "Jorginho", "De Arrascaeta", "Lino", "Lucas Paquetá", "Pedro"))
        );
        
        jogadoresTimes.put("Palmeiras", new ArrayList<>(List.of(
            "Carlos Miguel", "Giay", "Gustavo Gómez", "Murilo", "Artur", "Emiliano Martínez", "Andreas Pereira", "Alan", "Arias", "Ramon Sosa", "Flaco López"))
        );
        
        jogadoresTimes.put("Fluminense", new ArrayList<>(List.of(
            "Fábio", "Samuel Xavier", "Jemmes", "Freytes", "Renê", "Martinelli", "Hércules", "Savarino", "Serna", "Canobbio", "John Kennedy"))
        );
        
        jogadoresTimes.put("São Paulo", new ArrayList<>(List.of(
            "Rafael", "Cédric Soares", "Sabino", "Alan Franco", "Wendell", "Danielzinho", "Bobadilla", "Luciano", "Artur", "Calleri", "Lucca"))
        );
        
        jogadoresTimes.put("Bahia", new ArrayList<>(List.of(
            "Leo Vieira", "Luciano", "Santiago Ramos", "David", "Acevedo", "Jean Lucas", "Alexandre", "Everton Ribeiro", "Pulga", "Everaldo", "Oliveira"))
        );
        
        jogadoresTimes.put("Athletico-PR", new ArrayList<>(List.of(
            "Santos", "Benavídez", "Terán", "Léo Pelé", "Esquivel", "Felipinho", "Zapelli", "João Cruz", "Julimar", "Kevin Viveros", "Mendoza"))
        );
        
        jogadoresTimes.put("Coritiba", new ArrayList<>(List.of(
            "Pedro Morisco", "Tinga", "Maicon", "Tiago Cóser", "Bruno Melo", "Willian Oliveira", "Sebastián Gómez", "Vini Paulista", "Lucas Ronier", "Lavega", "Pedro Rocha"))
        );
        
        jogadoresTimes.put("Bragantino", new ArrayList<>(List.of(
            "Tiago Volpi", "Sant'Anna", "Alix", "Gustavo Marques", "J. Capixaba", "Matheus Fernandes", "Gustavo Neves", "Sosa", "Lucas Barbosa", "Mosquera", "Pitta"))
        );
        
        jogadoresTimes.put("Botafogo", new ArrayList<>(List.of(
            "Raúl", "Vitinho", "Bastos", "Alexander Barboza", "Alex Telles", "Danilo", "Medina", "Montoro", "Santiago Rodríguez", "Arthur Cabral", "Barrera"))
        );
        
        jogadoresTimes.put("Vasco", new ArrayList<>(List.of(
            "Léo Jardim", "Paulo Henrique", "Saldivia", "Robert Renan", "Cuiabano", "Cauan Barros", "Thiago Mendes", "Tchê Tchê", "Rojas", "Andrés Gómez", "David"))
        );
        
        jogadoresTimes.put("Vitória", new ArrayList<>(List.of(
            "Gabriel", "Riccieli", "Camutanga", "Zé Marcos", "Mateus Silva", "Baralhas", "Caíque Gonçalves", "Ramon", "Matheuzinho", "Aitor", "Renato Kayzer"))
        );
        
        jogadoresTimes.put("Atlético-MG", new ArrayList<>(List.of(
            "Everson", "Preciado", "Alonso", "Ruan", "Renan Lodi", "Alan Franco", "Maycon", "Bernard", "Victor Hugo", "Dudu", "Hulk"))
        );
        
        jogadoresTimes.put("Grêmio", new ArrayList<>(List.of(
            "Weverton", "João Pedro", "Gustavo Martins", "Wagner Leonardo", "Marlon", "Noriega", "Arthur", "Tetê", "Monsalve", "Amuzu", "Carlos Vinícius"))
        );
        
        jogadoresTimes.put("Internacional", new ArrayList<>(List.of(
            "Rochet", "Bruno Gomes", "Félix Torres", "Victor Gabriel", "Matheus Bahia", "Bruno Henrique", "Villagra", "Alan Patrick", "Vitinho", "Borré", "Carbonero"))
        );
        
        jogadoresTimes.put("Santos", new ArrayList<>(List.of(
            "Gabriel Brazão", "Igor Vinícius", "Adonis Frías", "Luan Peres", "Vinícius Lira", "João Schmidt", "Zé Rafael", "Gabriel Menino", "Neymar", "Gabigol", "Barreal"))
        );
        
        jogadoresTimes.put("Cruzeiro", new ArrayList<>(List.of(
            "Cássio", "William", "Fabrício Bruno", "Villalba", "Kaiki Bruno", "Lucas Romero", "Lucas Silva", "Gerson", "Matheus Pereira", "Arroyo", "Kaio Jorge"))
        );
        
        jogadoresTimes.put("Corinthians", new ArrayList<>(List.of(
            "Felipe Longo", "Matheuzinho", "André Ramalho", "Gabriel Paulista", "Matheus Bidu", "Raniele", "Allan", "Rodrigo Garro", "Memphis Depay", "Kaio César", "Yuri Alberto"))
        );
        
        jogadoresTimes.put("Mirassol", new ArrayList<>(List.of(
            "Walter", "Igor Formiga", "Victor", "Lucas Oliveira", "Victor Luis", "José Aldo", "Neto Moura", "Shaylon", "Alesson", "André Luis", "Edson Carioca"))
        );
        
        jogadoresTimes.put("Remo", new ArrayList<>(List.of(
            "Marcelo Rangel", "Matheus Alexandre", "Marllon", "Tchamba", "Mayk", "José Welison", "Patrick", "Marcelinho", "Vítor Bueno", "Jajá", "Gabriel Taliari"))
        );
        
        jogadoresTimes.put("Chapecoense", new ArrayList<>(List.of(
            "Rafael Santos", "Marcos Vinicius", "Bruno Leonardo", "Eduardo Doma", "Bruno Pacheco", "Camilo", "Higor Meritão", "Vinicius Balieiro", "Ítalo", "Yannick Bolasie", "Marcinho"))
        );
        
        return jogadoresTimes;
    }
}
