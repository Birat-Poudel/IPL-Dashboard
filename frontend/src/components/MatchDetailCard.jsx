import PropTypes from 'prop-types'
import { Link } from 'react-router-dom'
import './MatchDetailCard.scss'
import CalendarIcon from '../../src/assets/calendar.svg';
import LocationIcon from '../../src/assets/location.svg';
import WinnerIcon from '../../src/assets/winner.svg';

const MatchDetailCard = ({ teamName, match }) => {

    if (!match) return null

    const otherTeam = match.team1 === teamName ? match.team2 : match.team1
    const isMatchWon = teamName === match.matchWinner;

    const styles = {
        display: 'flex',
        alignItems: 'center',
    };
    const imgStyles = {
        display: 'block',
        marginRight: '0.5rem'
    }

    return (
        <div className={isMatchWon ? 'MatchDetailCard won-card' : 'MatchDetailCard lost-card'}>
            <div>
                <span className='vs'>vs</span>
                <h1><Link to={`/teams/${otherTeam}`} >{otherTeam}</Link></h1>
                <h2 className='match-date' style={styles}><img style={imgStyles} src={CalendarIcon} alt='calendar' /> {match.date}</h2>
                <h3 className='match-venue' style={styles}><img style={imgStyles} src={LocationIcon} alt='location' />{match.venue}</h3>
                <h3 className='match-result' style={styles}><img style={imgStyles} src={WinnerIcon} alt='winner' /> {match.matchWinner} won by {match.resultMargin} {match.result}</h3>
            </div>
            <div className='additional-details'>
                <h3>First Innings</h3>
                <p>{match.team1}</p>
                <h3>Second Innings</h3>
                <p>{match.team2}</p>
                <h3>Man of the match</h3>
                <p>{match.playerOfMatch}</p>
                <h3>Umpires</h3>
                <p>{match.umpire1}, {match.umpire2}</p>
            </div>

        </div >
    )
}

MatchDetailCard.propTypes = {
    match: PropTypes.shape({
        team1: PropTypes.string.isRequired,
        team2: PropTypes.string.isRequired,
        date: PropTypes.string.isRequired,
        venue: PropTypes.string.isRequired,
        matchWinner: PropTypes.string.isRequired,
        resultMargin: PropTypes.string.isRequired,
        result: PropTypes.string.isRequired,
        playerOfMatch: PropTypes.string.isRequired,
        umpire1: PropTypes.string.isRequired,
        umpire2: PropTypes.string.isRequired,
    }),
    teamName: PropTypes.string
};

export default MatchDetailCard