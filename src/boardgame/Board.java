package boardgame;


public class Board {
	private int linhas;
	private int colunas;
	private Piece[][] pieces;
	
	
	public Board(int linhas, int colunas) {
		if (linhas < 1 || colunas <1) {
			throw new BoardException("Erro de criação de tabuleiro: Precisa ter pelo menos uma linha e uma coluna");
		}
		this.linhas = linhas;
		this.colunas = colunas;
		pieces = new Piece[linhas][colunas];
	}

	public int getLinhas() {
		return linhas;
	}

	public int getColunas() {
		return colunas;
	}
	
	public Piece piece(int linhas, int colunas) {
		if(!positionExists(linhas, colunas)) {
			throw new BoardException("Posição não existe");
		}
		return pieces[linhas][colunas];
	}
	
	public Piece piece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Posição não existe");
		}
		return pieces[position.getLinha()][position.getColuna()];
	}
	
	
	public void placePiece(Piece piece, Position position) {
		if(thereIsAPiece(position)) {
			throw new BoardException("Ja existe uma peça nessa posição." + position);
		}
		pieces[position.getLinha()][position.getColuna()] = piece;
		piece.position = position;
	}
	
	private boolean positionExists(int linha, int coluna) {
		return linha >= 0 && linha < linhas && coluna >= 0 && coluna < colunas;
	}
	
	public boolean positionExists(Position position) {
		return positionExists(position.getLinha(), position.getColuna());
	}
	
	public boolean thereIsAPiece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Posição não existe");
		}
		return piece(position) != null;
	}
}
