package youmeex.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import chess.ChessGame;

@RestController
public class ApiChessController {

	@PostMapping("/api/move")
	public Map<String, Object> move(String source, String target) {
		Map<String, Object> positions = new HashMap<>();
		ChessGame chessGame = chessController.chessGame;
		try {
			chessGame.move(source, target);

			positions.put("status", true);
			positions.put("source", source);
			positions.put("target", target);

			return positions;
		} catch (Exception e) {

			positions.put("status", false);
			positions.put("errorMessage", e.getMessage());

			return positions;
		}

	}
}
