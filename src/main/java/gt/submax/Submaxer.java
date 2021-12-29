package gt.submax;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Submaxer {

	/**
	 * Buferio Elmentas sudarytas iš skaitinės vertės bei indekso kuriuo buvo paimtas iš pradinio masyvo. (sk,i)
	 * 
	 * Algoritmas:
	 * 
	 * 1) dešinysis atkarpos galas ima elementą (sk,i_right) iš duomenų masyvo ir
	 * lygina su eilės dešiniuoju elementu: righPeek.
	 * 
	 * 2) Jeigu duomenų skaičius yra mažesnis nei rightPeek arba eilė tuščia, tada
	 * deda elementą į eilę su rightPush ( ir praleidžiam sekantį žingsnį )
	 * 
	 * 3) Jeigu duomenų skaičius lygus arba didesnis nei rightPeek, tada šalinam
	 * elementą iš dešinės pusės rightPop, ir kartojam ankstesnį žingsnį
	 * 
	 * 4) Dabar imam kairįjį atkarpos galą i_left ( i_left = i_right - m arba
	 * i_right=i_left+m, priklausomai kurį atkarpos galą pasirinksi atskaitos tašku
	 * ) Jeigu leftPeek indeksas mažesnis nei i_left, tada pašalinam elementą iš
	 * eilės su leftPop. Kitu atveju leftPeek yra tas maksimalus akarpos skaičius.
	 * 
	 */
	public List<Integer> findSubmaxes(List<Integer> data, int interval) {
		List<Integer> rez = new ArrayList<>();

		LinkedList<BufferElement> buffer = new LinkedList<>();

		for (int iRight = 0; iRight < data.size(); iRight++) {

			int element = data.get(iRight);

			while (buffer.size() > 0 && element > buffer.peekLast().getSk()) {
				buffer.pollLast();
			}

			buffer.addLast(new BufferElement(element, iRight));

			int iLeft = iRight - interval + 1; // +1 because including the current element

			if (iLeft < 0) {
				continue;
			}

			rez.add(buffer.peekFirst().getSk());

			if (iLeft >= buffer.peekFirst().getI()) {
				buffer.pollFirst();
			}
		}

		return rez;
	}
}
