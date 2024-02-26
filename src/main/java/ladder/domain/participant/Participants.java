package ladder.domain.participant;

import java.util.List;
import java.util.Set;

public class Participants {
    private static final int MIN_PARTICIPANTS_COUNT = 2;

    private final List<Participant> participants;

    public Participants(final List<String> names) {
        validateParticipantsCount(names);
        validateDuplicatedNames(names);
        this.participants = names.stream()
                .map(Participant::new)
                .toList();
    }

    private void validateParticipantsCount(final List<String> names) {
        if (names.size() < MIN_PARTICIPANTS_COUNT) {
            throw new IllegalArgumentException("참가자 수는 2명 이상입니다.");
        }
    }

    private void validateDuplicatedNames(final List<String> names) {
        final Set<String> uniqueNames = Set.copyOf(names);
        if (uniqueNames.size() < names.size()) {
            throw new IllegalArgumentException("중복된 이름이 입력되었습니다.");
        }
    }

    public int getNecessaryLadderWidth() {
        return participants.size() - 1;
    }

    public List<Participant> getValues() {
        return participants;
    }
}