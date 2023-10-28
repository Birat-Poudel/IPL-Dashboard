import PropTypes from 'prop-types'
import { Link } from 'react-router-dom'
import './MatchSmallCard.scss'
import WinnerIcon from '../../src/assets/winner.svg';

const MatchSmallCard = ({ teamName, match }) => {

    if (!match) return null

    const otherTeam = match.team1 === teamName ? match.team2 : match.team1
    const isMatchWon = teamName === match.matchWinner;

    const styles = {
        display: 'flex',
        alignItems: 'flex-start',
    };
    const imgStyles = {
        display: 'block',
        marginRight: '0.5rem'
    }

    return (
        <div className={isMatchWon ? 'MatchSmallCard won-card' : 'MatchSmallCard lost-card'}>
            <span className='vs'>vs</span>
            <h3><Link to={`/teams/${otherTeam}`} >{otherTeam}</Link></h3>
            <p className='match-result' style={styles}><img style={imgStyles} src={WinnerIcon} alt='winner' /> {match.matchWinner} won by {match.resultMargin} {match.result}</p>
        </div >
    )
}

MatchSmallCard.propTypes = {
    match: PropTypes.shape({
        team1: PropTypes.string.isRequired,
        team2: PropTypes.string.isRequired,
        matchWinner: PropTypes.string.isRequired,
        resultMargin: PropTypes.string.isRequired,
        result: PropTypes.string.isRequired
    }).isRequired,
    teamName: PropTypes.string.isRequired
};

export default MatchSmallCard