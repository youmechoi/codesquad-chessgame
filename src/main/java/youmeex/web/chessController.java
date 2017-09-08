package youmeex.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import chess.ChessGame;
import chess.Rank;

@Controller
public class chessController {

	public static ChessGame chessGame;

	@GetMapping("/")
	public String home(Model model) {
		chessGame = new ChessGame();
		chessGame.initialize();

		ChessDto chessDto = ChessDto.create(chessGame);
		model.addAttribute("chess", chessDto);

		return "chessboard";
	}

	@PostMapping("/move")
	public String move(Model model, String source, String target) {
		
		chessGame.move(source, target);

		ChessDto chessDto = ChessDto.create(chessGame);
		model.addAttribute("chess", chessDto);

		return "chessboard";
	}

}
